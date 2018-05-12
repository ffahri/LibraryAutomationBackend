package com.webischia.LibraryAutomationBackend.Service;

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
}
