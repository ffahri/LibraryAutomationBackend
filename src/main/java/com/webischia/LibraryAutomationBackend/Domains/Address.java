package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class Address {
    int addressID;
    String addressName;
    String addressLine1;
    String addressLine2;
    int cityID;
    int userID;
}
