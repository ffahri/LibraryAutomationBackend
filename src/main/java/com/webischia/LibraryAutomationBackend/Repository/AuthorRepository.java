package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Author addAuthor(Author author) {
        jdbcTemplate.execute("INSERT INTO AUTHOR(authorName,authorLastName) VALUES('"+author.getAuthorName()+"','"+author.getAuthorLastName()+"')");
        return jdbcTemplate.queryForObject("select authorID,authorName,authorLastName from AUTHOR where authorName ='"+author.getAuthorName() +"' and authorLastName='"+author.getAuthorLastName()+"'"
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));
    }


    public Author updateAuthor(Author author, int id) {
        jdbcTemplate.execute("UPDATE AUTHOR SET authorName='"+author.getAuthorName()+"',authorLastName='"+author.getAuthorLastName()+"' WHERE authorID= "+id);
        return getAuthor(id);
    }

    public void deleteAuthor(int id) {
        jdbcTemplate.execute("DELETE FROM AUTHOR WHERE authorID= "+id);
    }

    public Author getAuthor(int id) {
        return jdbcTemplate.queryForObject("select authorID,authorName,authorLastName from AUTHOR where authorID = "+id
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));    }

    public List<Author> getAllAuthors() {
        List<Author> tmp = jdbcTemplate.query("select authorID,authorName,authorLastName from AUTHOR"
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));
    return tmp;
    }

}


