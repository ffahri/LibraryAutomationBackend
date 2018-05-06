package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class User {

    int userID;
    int accessID;
    String firstName;
    String lastName;
    String mail;
    String phone;
    String userPassword; //yes thats not ideal but...
        //dont want password d'oh ?

    public User() {
    }

    public User(int userID, int accessID, String firstName, String lastName, String mail, String phone, String userPassword) {
        this.userID = userID;
        this.accessID = accessID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phone = phone;
        this.userPassword = userPassword;
    }
}
