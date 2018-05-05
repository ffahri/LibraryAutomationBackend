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
    int ISBN;
    int stockNo;
    String pageNumber;
    String sizeValue;
    String editionNo;
    String printYear;
    Date editDate;
    String itemLang;

}
