package com.webischia.LibraryAutomationBackend.api.v1.mapper;

import com.webischia.LibraryAutomationBackend.Domains.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        System.out.println(i);
        user.setUserID(rs.getInt("userID"));
        user.setAccessID(rs.getInt("accessID"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setMail(rs.getString("mail"));
        user.setPhone(rs.getString("phone"));
        user.setUserPassword(rs.getString("userPassword"));
        return user;
    }
}
