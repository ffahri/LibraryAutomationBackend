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
}
