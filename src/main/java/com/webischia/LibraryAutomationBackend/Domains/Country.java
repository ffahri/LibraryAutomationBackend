package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class Country {
    int countryID;
    String countryName;

    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }
}
