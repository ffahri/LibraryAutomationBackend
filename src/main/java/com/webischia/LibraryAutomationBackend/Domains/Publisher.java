package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Publisher {
    int publisherID;
    String publisherName;

    public Publisher(int publisherID, String publisherName) {
        this.publisherID = publisherID;
        this.publisherName = publisherName;
    }
}
