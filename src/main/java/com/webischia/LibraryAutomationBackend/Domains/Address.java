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

    public Address(int addressID, String addressName, String addressLine1, String addressLine2, int cityID, int userID) {
        this.addressID = addressID;
        this.addressName = addressName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.cityID = cityID;
        this.userID = userID;
    }
}
