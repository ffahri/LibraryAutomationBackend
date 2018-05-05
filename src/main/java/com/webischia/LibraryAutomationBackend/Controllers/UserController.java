package com.webischia.LibraryAutomationBackend.Controllers;


import com.webischia.LibraryAutomationBackend.Service.UserService;
import com.webischia.LibraryAutomationBackend.api.v1.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api/v1/user/","/api/v1/users"})
public class UserController {

    //change password - register - ??
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //REGISTER
    @PutMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO)
    {
       // userService.register(userDTO);

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
    }
}
