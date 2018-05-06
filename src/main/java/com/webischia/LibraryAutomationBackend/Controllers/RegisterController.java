package com.webischia.LibraryAutomationBackend.Controllers;


import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.UserService;
import com.webischia.LibraryAutomationBackend.api.v1.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/api/v1/register/","/api/v1/register"})
public class RegisterController {

    //change password - register - ??
    UserService userService;
    ItemService itemService;

    public RegisterController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }



    //REGISTER
    @PutMapping("/new")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO)
    {
       // userService.register(userDTO);

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
    }



}
