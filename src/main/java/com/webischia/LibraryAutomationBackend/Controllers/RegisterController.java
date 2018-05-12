package com.webischia.LibraryAutomationBackend.Controllers;


import com.webischia.LibraryAutomationBackend.Domains.Author;
import com.webischia.LibraryAutomationBackend.Domains.City;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Domains.UserAdressDTO;
import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.UserService;
import com.webischia.LibraryAutomationBackend.api.v1.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/new")
    public ResponseEntity<UserAdressDTO> register(@RequestBody UserAdressDTO user)
    {
       // userService.register(userDTO);
        userService.register(user);

        return new ResponseEntity<UserAdressDTO>(user, HttpStatus.CREATED);
    }

    @GetMapping("/city/get/all")
    public ResponseEntity<List<City>>getAllCities()
    {
        return new ResponseEntity<List<City>>(userService.getAllCities(),HttpStatus.OK);
    }

}
