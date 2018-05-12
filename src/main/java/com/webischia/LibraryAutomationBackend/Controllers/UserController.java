package com.webischia.LibraryAutomationBackend.Controllers;

import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import com.webischia.LibraryAutomationBackend.Domains.Items;
import com.webischia.LibraryAutomationBackend.Domains.User;
import com.webischia.LibraryAutomationBackend.Domains.UserAdressDTO;
import com.webischia.LibraryAutomationBackend.Repository.ItemRepository;
import com.webischia.LibraryAutomationBackend.Repository.UserRepository;
import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/api/v1/user/","/api/v1/user"})
public class UserController {

    UserService userService;
    ItemService itemService;

    public UserController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @PreAuthorize("hasAuthority('User')")
    @GetMapping("/info/{id}")
    public ResponseEntity<UserAdressDTO> addItemType(@PathVariable int id)
    {

        return new ResponseEntity<>(userService.findByID(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('User')")
    @GetMapping("/items/get/all")
    public ResponseEntity<List<Items>> getAllItems()
    {

        return new ResponseEntity<List<Items>>(itemService.getAllItems(), HttpStatus.OK);
    }

}
