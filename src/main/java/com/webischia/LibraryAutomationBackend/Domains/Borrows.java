package com.webischia.LibraryAutomationBackend.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrows {

    int userID;
    int stockID;
    Timestamp borrowDate;
    int borrowLength;
    Timestamp returnDate;
    int status;
    int extended;
    String mail;
    String lokasyon1;
    String lokasyon2;
    String itemName;

    public Borrows(int userID, int stockID, Timestamp borrowDate,int borrowLength ,int extended) {
        this.userID = userID;
        this.stockID = stockID;
        this.borrowDate = borrowDate;
        this.borrowLength = borrowLength;
        this.extended = extended;
    }

    public Borrows(int userID, int stockID, Timestamp borrowDate, String lokasyon1, String lokasyon2, String itemName,int borrowLength) {
        this.userID = userID;
        this.stockID = stockID;
        this.borrowDate = borrowDate;
        this.lokasyon1 = lokasyon1;
        this.lokasyon2 = lokasyon2;
        this.itemName = itemName;
        this.borrowLength =borrowLength;
    }

    //    userID int not null,
//    stockID int not null,
//    borrowDate timestamp not null,
//    borrowLength int not null,
//    returnDate timestamp,
//    status  NUMBER(1,0),---0 false 1 true ?
//    extended int not null,
}
