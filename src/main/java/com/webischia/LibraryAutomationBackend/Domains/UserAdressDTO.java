package com.webischia.LibraryAutomationBackend.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAdressDTO {

    User user;
    Address address;

}
