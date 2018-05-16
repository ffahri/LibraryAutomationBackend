package com.webischia.LibraryAutomationBackend.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    int itemID;
    int stockID;
    String locationLetter1;
    String locationLetter2;
    Timestamp addDate;
}
