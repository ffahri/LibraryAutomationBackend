package com.webischia.LibraryAutomationBackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api/v1/management/","/api/v1/management"})
public class ManagementController {
    //item ekle item tipi ekle yazar ekle yayınevi ekle

    @PostMapping("/itemtype/add")
    public ResponseEntity<>addItemType()
    {

    }

    @GetMapping("/itemtype/delete/{id}")
    public ResponseEntity<>deleteItemType()
    {

    }

    @GetMapping("/itemtype/get/{id}")
    public ResponseEntity<>getItemType()
    {

    }
    @GetMapping("/itemtype/get/all")
    public ResponseEntity<>getAllItemType()
    {

    }
    @PostMapping("/item/add")
    public ResponseEntity<>addItem()
    {

    }
    @GetMapping("/item/delete/{id}")
    public ResponseEntity<>deleteItem()
    {

    }
    @GetMapping("/item/get/{id}")
    public ResponseEntity<>getItem()
    {

    }
    @GetMapping("/item/get/all")
    public ResponseEntity<>getAllItems()
    {

    }



}
