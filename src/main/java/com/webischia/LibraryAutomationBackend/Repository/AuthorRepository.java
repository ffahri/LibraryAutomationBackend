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
        jdbcTemplate.execute("INSERT INTO FAHRI2.AUTHOR(authorName,authorLastName) VALUES('"+author.getAuthorName()+"','"+author.getAuthorLastName()+"')");
        return jdbcTemplate.queryForObject("select authorID,authorName,authorLastName from FAHRI2.AUTHOR where authorName ='"+author.getAuthorName() +"' and authorLastName='"+author.getAuthorLastName()+"'"
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));
    }


    public Author updateAuthor(Author author, int id) {
        jdbcTemplate.execute("UPDATE FAHRI2.AUTHOR SET authorName='"+author.getAuthorName()+"',authorLastName='"+author.getAuthorLastName()+"' WHERE authorID= "+id);
        return getAuthor(id);
    }

    public void deleteAuthor(int id) {
        jdbcTemplate.execute("DELETE FROM FAHRI2.AUTHOR WHERE authorID= "+id);
    }

    public Author getAuthor(int id) {
        return jdbcTemplate.queryForObject("select authorID,authorName,authorLastName from FAHRI2.AUTHOR where authorID = "+id
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));    }

    public List<Author> getAllAuthors() {
        List<Author> tmp = jdbcTemplate.query("select authorID,authorName,authorLastName from FAHRI2.AUTHOR ORDER BY authorID"
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));
    return tmp;
    }
    public List<Author> searchKeyword(String keyword) {
        List<Author> tmp = jdbcTemplate.query("select authorID,authorName,authorLastName from FAHRI2.AUTHOR WHERE authorName LIKE '%"+keyword+"%' or authorLastName LIKE '%"+keyword+"%'"
                ,(rs,rowNum) ->new Author(rs.getInt("authorID"),rs.getString("authorName"),rs.getString("authorLastName")));
        return tmp;
    }
}


