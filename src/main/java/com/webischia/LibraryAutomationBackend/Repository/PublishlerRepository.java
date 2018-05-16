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
        jdbcTemplate.execute("INSERT INTO FAHRI2.PUBLISHER(publisherName) VALUES('"+publisher.getPublisherName()+"')");
        return jdbcTemplate.queryForObject("select publisherID,publisherName from FAHRI2.PUBLISHER where publisherName ='"+publisher.getPublisherName()+"'"
                ,(rs,rowNum) ->new Publisher(rs.getInt("publisherID"),rs.getString("publisherName")));
    }


    public Publisher updatePublisher(Publisher publisher, int id) {
        jdbcTemplate.execute("UPDATE FAHRI2.PUBLISHER SET publisherName='"+publisher.getPublisherName()+"' WHERE publisherID= "+id);
        return getPublisher(id);
    }

    public void deletePublisher(int id) {
        jdbcTemplate.execute("DELETE FROM FAHRI2.PUBLISHER WHERE publisherID= "+id);
    }

    public List<Publisher> getAllPublishers() {
        List<Publisher> tmp = jdbcTemplate.query("select publisherID,publisherName from FAHRI2.PUBLISHER ORDER BY publisherID"
                ,(rs,rowNum) ->new Publisher(rs.getInt("publisherID"),rs.getString("publisherName")));
        return tmp;
    }

    public Publisher getPublisher(int id) {

        return jdbcTemplate.queryForObject("select publisherID,publisherName from FAHRI2.PUBLISHER where publisherID= "+id
                ,(rs,rowNum) ->new Publisher(rs.getInt("publisherID"),rs.getString("publisherName")));    }

    public List<Publisher> searchKeyword(String keyword) {
        List<Publisher> tmp = jdbcTemplate.query("select publisherID,publisherName from FAHRI2.PUBLISHER WHERE publisherName LIKE '%"+keyword+"%' ORDER BY publisherID"
                ,(rs,rowNum) ->new Publisher(rs.getInt("publisherID"),rs.getString("publisherName")));
        return tmp;
    }
}
