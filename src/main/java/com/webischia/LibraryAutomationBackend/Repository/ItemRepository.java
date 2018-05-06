package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // thanks Java 8, look the custom RowMapper
    public List<ItemType> getAllItemTypes() {

        List<ItemType> result = jdbcTemplate.query(
                "SELECT id,name FROM ITEMTYPE",
                (rs, rowNum) -> new ItemType(rs.getInt("id"),rs.getString("name")) );

        return result;

    }

    public String test(){
        String result = (String)jdbcTemplate.queryForObject("select user_name from demo_users where user_id=1",String.class);

        return result;
    }
}
