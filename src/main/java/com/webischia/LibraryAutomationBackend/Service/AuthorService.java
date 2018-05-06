package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService  {


    void addAuthor(Author author);
    void updateAuthor(Author author,int id);
    void deleteAuthor(int id);
    Author getAuthor(int id);
    List<Author> getAllAuthors();
}
