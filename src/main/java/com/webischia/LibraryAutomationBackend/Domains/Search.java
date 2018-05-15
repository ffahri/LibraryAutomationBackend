package com.webischia.LibraryAutomationBackend.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Search {

    String keyword;
    String publisherName;
    String authorName;
}
