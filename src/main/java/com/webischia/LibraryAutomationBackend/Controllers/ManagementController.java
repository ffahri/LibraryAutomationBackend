package com.webischia.LibraryAutomationBackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api/v1/management/","/api/v1/management"})
public class ManagementController {
    //item ekle item tipi ekle yazar ekle yayınevi ekle
    //@PreAuthorize("hasAuthority('Client')
    @PostMapping("/itemtype/add")
    public ResponseEntity<>addItemType()
    {

    }
    //@PreAuthorize("hasAuthority('Client')
    @PostMapping("/itemtype/edit/{id}")
    public ResponseEntity<>editItemType()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/itemtype/delete/{id}")
    public ResponseEntity<>deleteItemType()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/itemtype/get/{id}")
    public ResponseEntity<>getItemType()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/itemtype/get/all")
    public ResponseEntity<>getAllItemType()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/item/add")
    public ResponseEntity<>addItem()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/item/edit/{id}")
    public ResponseEntity<>editItem()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/item/delete/{id}")
    public ResponseEntity<>deleteItem()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/item/get/{id}")
    public ResponseEntity<>getItem()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/item/get/all")
    public ResponseEntity<>getAllItems()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/author/add")
    public ResponseEntity<>addAuthor()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/author/delete")
    public ResponseEntity<>deleteAuthor()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/author/get/{id}")
    public ResponseEntity<>getAuthor()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/author/edit/{id}")
    public ResponseEntity<>editAuthor()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/author/get/all")
    public ResponseEntity<>getAllAuthors()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/publisher/add")
    public ResponseEntity<>addPublisher()
    {

    }
    //@PreAuthorize("hasAuthority('Client')
    @GetMapping("/publisher/delete")
    public ResponseEntity<>deletePublisher()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/publisher/get/{id}")
    public ResponseEntity<>getPublisher()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @PostMapping("/publisher/edit/{id}")
    public ResponseEntity<>editPublisher()
    {

    }
    //@PreAuthorize("hasAuthority('Client')

    @GetMapping("/publisher/get/all")
    public ResponseEntity<>getAllPublishers()
    {

    }


}
