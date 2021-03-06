package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.*;
import com.webischia.LibraryAutomationBackend.api.v1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AccessLevel getAccessLevel(int id)
    {
        return jdbcTemplate.queryForObject("select accessID,accessDescription from FAHRI2.ACCESS_LEVEL where accessID= "+id,
                (rs,rowNum) ->new AccessLevel(rs.getInt("accessID"),rs.getString("accessDescription")));
    }
//    int userID;
//    int accessID;
//    String firstName;
//    String lastName;
//    String mail;
//    String phone;
//    String userPassword;
    public User findByMail(String mail){

        String sqlQ ="select userID,accessID,firstName,lastName,mail,phone,userPassword from FAHRI2.USERS where mail='"+mail+"'";

        return jdbcTemplate.queryForObject(sqlQ,new UserMapper());


    }
    public int mailtoID(String mail){

        String sqlQ ="select userID from FAHRI2.USERS where mail='"+mail+"'";

        return jdbcTemplate.queryForObject(sqlQ,Integer.class);


    }


    public UserAdressDTO findByID(int id)
    {
        UserAdressDTO dto = new UserAdressDTO();
        dto.setUser(jdbcTemplate.queryForObject("select * from FAHRI2.USERS where userID= "+id,new UserMapper()));
        try {
            dto.setAddress(jdbcTemplate.queryForObject("select * from FAHRI2.ADDRESS where userID= " + id,
                    (rs, rowNum) -> new Address(rs.getInt("addressID"), rs.getString("addressName"), rs.getString("addressLine1"),
                            rs.getString("addressLine2"), rs.getInt("cityID"), rs.getInt("userID"))));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    public List<City> getAllCities() {
        List<City> tmp = jdbcTemplate.query("select cityID,countryID,cityName from FAHRI2.CITY ",
                (rs,rowNum) ->new City(rs.getInt("cityID"),rs.getInt("countryID"),rs.getString("cityName")));
        return tmp;
    }

    public UserAdressDTO register(UserAdressDTO user){

        //SHA-256 ÇEVİRİYORUM daha kısa yolu var bence
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = new byte[0];
        try {
            hash = digest.digest(user.getUser().getUserPassword().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        //uzun sorgu çok puan ? : )
        String sqlUser = "INSERT INTO FAHRI2.USERS(accessID,firstName,lastName,mail,phone,userPassword)" +
                "VALUES((SELECT accessID from FAHRI2.ACCESS_LEVEL WHERE accessDescription='User'),'"+user.getUser().getFirstName()+"','"+user.getUser().getLastName()+"','"+user.getUser().getMail()+
                "','"+user.getUser().getPhone()+"','"+hexString.toString()+"')";

        //önce user -> sonra adres foreign key
        String sqlAddress="INSERT INTO FAHRI2.ADDRESS(addressName,addressLine1,addressLine2,cityID,userID)" +
                "VALUES('"+user.getAddress().getAddressName()+"','"+user.getAddress().getAddressLine1()+"','"+user.getAddress().getAddressLine2()+
                "',"+user.getAddress().getCityID()+",(SELECT userID FROM FAHRI2.USERS WHERE mail='"+user.getUser().getMail()+"'))";
        jdbcTemplate.execute(sqlUser);

        jdbcTemplate.execute(sqlAddress);
        return findByID( findByMail(user.getUser().getMail()) .getUserID()); //:D

    }

    public void uzat(int sure , int id){
        sure = 15;

        jdbcTemplate.execute("UPDATE FAHRI2.USERBORROW SET borrowLength = "+sure+",borrowDate = CURRENT_TIMESTAMP WHERE stockID = "+id);
    }

    public void oduncAl(Borrows borrows,int id){
        borrows.setStockID(loctoID(borrows.getLokasyon1(),borrows.getLokasyon2()));
        jdbcTemplate.execute("INSERT INTO FAHRI2.USERBORROW(userID,stockID,borrowLength,status) VALUES("+id+","+borrows.getStockID()+",15,1)");

    } //yayın idsi
    public void iadeAl(Borrows borrows){
        jdbcTemplate.execute("UPDATE FAHRI2.USERBORROW SET returnDate = CURRENT_TIMESTAMP , status = 0 WHERE stockID = (SELECT stockID FROM FAHRI2.STOCKITEM WHERE locationLetter1 ='"+borrows.getLokasyon1()+"' and locationLetter2='"+borrows.getLokasyon2()+"')");
    }

    public int loctoID(String let1,String let2)
    {
        String sqlQ ="select stockID from FAHRI2.STOCKITEM where locationLetter1='"+let1+"' and locationLetter2='"+let2+"'";

        return jdbcTemplate.queryForObject(sqlQ,Integer.class);

    }

    public List<Borrows> aktifleriListele(int id) {
        List<Borrows> tmp = jdbcTemplate.query("select item.itemName,ub.borrowDate,st.locationLetter1,st.locationLetter2,st.stockID,ub.userID,ub.borrowLength from FAHRI2.USERBORROW ub join FAHRI2.STOCKITEM st on ub.stockID = st.stockID join FAHRI2.ITEMS item on st.itemID = item.itemID WHERE ub.userID= "+id+" and ub.status = 1",
                (rs,rowNum) ->new Borrows(rs.getInt("userID"),rs.getInt("stockID"),rs.getTimestamp("borrowDate"),rs.getString("locationLetter1"),rs.getString("locationLetter2"),rs.getString("itemName"),rs.getInt("borrowLength")));
        return tmp;    }


    public List<Borrows> hepsiniListele(int id) {
        List<Borrows> tmp = jdbcTemplate.query("select * from FAHRI2.USERBORROW WHERE userID = "+id+"",
                (rs,rowNum) ->new Borrows(rs.getInt("userID"),rs.getInt("stockID"),rs.getTimestamp("borrowDate"),rs.getInt("borrowLength"),rs.getInt("extended")));
        return tmp;
    }
}
