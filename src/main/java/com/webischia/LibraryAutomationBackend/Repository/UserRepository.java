package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.AccessLevel;
import com.webischia.LibraryAutomationBackend.Domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AccessLevel getAccessLevel(int id)
    {
        return jdbcTemplate.queryForObject("select accessID,accessDescription from ACCESS_LEVEL where accessID ="+id,
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

        return jdbcTemplate.queryForObject("select userID,accessID,firstName,lastName,mail,phone,userPassword from USERS where mail ="+mail,
                (rs,rowNum) ->new User(rs.getInt("userID"),rs.getInt("accessID"),rs.getString("firstName"),
                        rs.getString("lastName"),rs.getString("mail"),rs.getString("phone"),rs.getString("userPassword")));

    }
}
