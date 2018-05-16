package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Borrows;
import com.webischia.LibraryAutomationBackend.Domains.City;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Domains.UserAdressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserAdressDTO findByID(int id);
    List<City> getAllCities();
    UserAdressDTO register(UserAdressDTO user);
    int mailtoID(String mail);

    void oduncAl(Borrows borrows,int id); //yayın idsi
    void iadeAl(Borrows borrows);
    void uzat( int id);
    List<Borrows> aktifleriListele(int mail);
    List<Borrows> hepsiniListele(int id);
}
