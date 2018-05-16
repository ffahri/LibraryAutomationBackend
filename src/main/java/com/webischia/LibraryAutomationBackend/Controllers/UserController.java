package com.webischia.LibraryAutomationBackend.Controllers;

import com.webischia.LibraryAutomationBackend.Domains.*;
import com.webischia.LibraryAutomationBackend.Repository.ItemRepository;
import com.webischia.LibraryAutomationBackend.Repository.UserRepository;
import com.webischia.LibraryAutomationBackend.Service.AuthorService;
import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.PublishlerService;
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

    private final ItemService itemService;
    private final PublishlerService publishlerService;
    private final AuthorService authorService;
    private  final UserService userService;

    public UserController(ItemService itemService, PublishlerService publishlerService, AuthorService authorService, UserService userService) {
        this.itemService = itemService;
        this.publishlerService = publishlerService;
        this.authorService = authorService;
        this.userService = userService;
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
    @PreAuthorize("hasAuthority('User')")

    @GetMapping("/borrows/{userID}")
    public ResponseEntity<List<Borrows>>aktifleriList(@PathVariable int userID)
    {

        return new ResponseEntity<List<Borrows>>(userService.aktifleriListele(userID),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('User')")

    @GetMapping("/borrows/all/{userID}")
    public ResponseEntity<List<Borrows>>hepsiniList(@PathVariable int userID)
    {

        return new ResponseEntity<List<Borrows>>(userService.hepsiniListele(userID),HttpStatus.OK);
    }

    @GetMapping("/item/get/search/{keyword}")
    public ResponseEntity<List<Items>>searchItemByKeyword(@PathVariable String keyword)
    {

        return new ResponseEntity<List<Items>>(itemService.searchItemByKeyword(keyword),HttpStatus.OK);
    }

    @PostMapping("/item/get/search/post")
    public ResponseEntity<List<Items>>searchItemByPost(@RequestBody Search search)
    {

        return new ResponseEntity<List<Items>>(itemService.searchItemsByPost(search),HttpStatus.OK);
    }

    @GetMapping("/item/get/search/author/{authorID}")
    public ResponseEntity<List<Items>>searchItemByAuthorID(@PathVariable int authorID)
    {

        return new ResponseEntity<List<Items>>(itemService.searchItemsByAuthorID(authorID),HttpStatus.OK);
    }

    @GetMapping("/author/search/{keyword}")
    public ResponseEntity<List<Author>>searchAuthorByKeyword(@PathVariable String keyword)
    {

        return new ResponseEntity<List<Author>>(authorService.searchByKeyword(keyword),HttpStatus.OK);
    }
    @GetMapping("/publisher/search/{keyword}")
    public ResponseEntity<List<Publisher>>searchPublisherByKeyword(@PathVariable String keyword)
    {

        return new ResponseEntity<List<Publisher>>(publishlerService.searchByKeyword(keyword),HttpStatus.OK);
    }
    @GetMapping("/item/get/search/publisher/{publisherID}")
    public ResponseEntity<List<Items>>searchItemByPublisherID(@PathVariable int publisherID)
    {

        return new ResponseEntity<List<Items>>(itemService.searchItemsByPublisher(publisherID),HttpStatus.OK);
    }


}
