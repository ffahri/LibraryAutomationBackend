package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.City;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Domains.UserAdressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserAdressDTO findByID(int id);
    List<City> getAllCities();
    UserAdressDTO register(UserAdressDTO user);

}
