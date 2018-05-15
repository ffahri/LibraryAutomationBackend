package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Author;
import com.webischia.LibraryAutomationBackend.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.addAuthor(author);
    }

    @Override
    public Author updateAuthor(Author author, int id) {
        return authorRepository.updateAuthor(author,id);
    }

    @Override
    public void deleteAuthor(int id) {

        authorRepository.deleteAuthor(id);
    }

    @Override
    public Author getAuthor(int id) {

        return authorRepository.getAuthor(id);
    }

    @Override
    public List<Author> getAllAuthors() {

        return authorRepository.getAllAuthors();
    }

    @Override
    public List<Author> searchByKeyword(String keyword) {
        return authorRepository.searchKeyword(keyword);
    }
}
