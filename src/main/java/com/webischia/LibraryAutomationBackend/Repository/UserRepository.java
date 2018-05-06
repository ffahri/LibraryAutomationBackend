package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.AccessLevel;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.api.v1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        String sqlQ1 ="select userID,accessID,firstName,lastName,mail,phone,userPassword from FAHRI2.USERS where mail =";

        System.out.println(sqlQ);
        //jdbcTemplate.query(sqlQ,);
        return jdbcTemplate.queryForObject(sqlQ,new UserMapper());


    }
}
