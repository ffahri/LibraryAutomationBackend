package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(int id) {
        return userRepository.findByID(id);
    }
}
