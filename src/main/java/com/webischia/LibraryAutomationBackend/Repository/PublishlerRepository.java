package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublishlerRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.execute("INSERT INTO PUBLISHER(publisherName) VALUES("+publisher.getPublisherName()+")");
        return jdbcTemplate.queryForObject("select publisherID,publisherName from PUBLISHER where publisherName ="+publisher.getPublisherName()
                ,(rs,rowNum) ->new Publisher(rs.getInt("publisherID"),rs.getString("publisherName")));
    }


    public Publisher updatePublisher(Publisher publisher, int id) {
        return null;
    }

    public void deletePublisher(int id) {

    }

    public List<Publisher> getAllPublishers() {
        return null;
    }

    public Publisher getPublisher(int id) {
        return null;
    }
}
