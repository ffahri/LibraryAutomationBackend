package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

import java.util.Date;

//Le grandi cose non sono fatte d’impulso, ma attraverso una serie di piccole cose messe insieme. -van gogh
@Data
public class Items {
    int itemID;
    String itemName;
    int typeID;
    String itemDesc;
    String ISBN;
    String stockNo;
    String pageNumber;
    String sizeValue;
    String editionNo;
    String printYear;
    Date editDate;
    String itemLang;

    public Items(int itemID, String itemName, int typeID, String itemDesc, String ISBN, String stockNo, String pageNumber, String sizeValue, String editionNo, String printYear, Date editDate, String itemLang) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.typeID = typeID;
        this.itemDesc = itemDesc;
        this.ISBN = ISBN;
        this.stockNo = stockNo;
        this.pageNumber = pageNumber;
        this.sizeValue = sizeValue;
        this.editionNo = editionNo;
        this.printYear = printYear;
        this.editDate = editDate;
        this.itemLang = itemLang;
    }
}
