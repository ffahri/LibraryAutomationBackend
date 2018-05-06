package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

import java.util.Date;

@Data
public class AccessLevel {
    int accessID;
    String accessDescription;
    Date editDate;

    public AccessLevel(int accessID, String accessDescription) {
        this.accessID = accessID;
        this.accessDescription = accessDescription;
    }
}
