package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class Author {
    int authorID;
    String authorName;
    String authorLastName;

    public Author(int authorID, String authorName, String authorLastName) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
    }
}
