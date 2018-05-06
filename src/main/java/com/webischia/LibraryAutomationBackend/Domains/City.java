package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class City {
    int cityID;
    int countryID;
    String cityName;

    public City(int cityID, int countryID, String cityName) {
        this.cityID = cityID;
        this.countryID = countryID;
        this.cityName = cityName;
    }
}
