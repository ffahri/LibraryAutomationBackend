package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Borrows;
import com.webischia.LibraryAutomationBackend.Domains.City;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Domains.UserAdressDTO;
import com.webischia.LibraryAutomationBackend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAdressDTO findByID(int id) {
        return userRepository.findByID(id);
    }

    @Override
    public List<City> getAllCities() {
        return userRepository.getAllCities();
    }

    @Override
    public UserAdressDTO register(UserAdressDTO user) {
        return userRepository.register(user);
    }

    @Override
    public void oduncAl(Borrows borrows, int id) {
        userRepository.oduncAl(borrows,id);
    }

    @Override
    public void iadeAl(Borrows borrows) {
        userRepository.iadeAl(borrows);
    }

    @Override
    public void uzat(int id) {
        userRepository.uzat(15,id);
    }

    @Override
    public List<Borrows> aktifleriListele(int mail) {
        return userRepository.aktifleriListele(mail);
    }

    @Override
    public List<Borrows> hepsiniListele(int id) {
        return userRepository.hepsiniListele(id);
    }

    @Override
    public int mailtoID(String mail) {
        return userRepository.mailtoID(mail);
    }
}
