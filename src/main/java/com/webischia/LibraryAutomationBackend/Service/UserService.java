package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findByID(int id);


}
