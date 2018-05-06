package com.webischia.LibraryAutomationBackend.Controllers;

import com.webischia.LibraryAutomationBackend.Domains.Author;
import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import com.webischia.LibraryAutomationBackend.Domains.Items;
import com.webischia.LibraryAutomationBackend.Domains.Publisher;
import com.webischia.LibraryAutomationBackend.Service.AuthorService;
import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.PublishlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/api/v1/management/","/api/v1/management"})
public class ManagementController {
    //item ekle item tipi ekle yazar ekle yayınevi ekle

    private final ItemService itemService;
    private final PublishlerService publishlerService;
    private final AuthorService authorService;

    public ManagementController(ItemService itemService, PublishlerService publishlerService, AuthorService authorService) {
        this.itemService = itemService;
        this.publishlerService = publishlerService;
        this.authorService = authorService;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/itemtype/add")
    public ResponseEntity<ItemType>addItemType(@RequestBody ItemType itemType)
    {


        return new ResponseEntity<>(itemService.addItemType(itemType.getTypeName()),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/itemtype/edit/{id}")
    public ResponseEntity<ItemType>editItemType(@RequestBody ItemType itemType , @PathVariable int id)
    {

        return new ResponseEntity<>(itemService.updateItemType(itemType,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/itemtype/delete/{id}")
    public ResponseEntity<String>deleteItemType(@PathVariable int id)
    {
        itemService.deleteItemType(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/itemtype/get/{id}")
    public ResponseEntity<ItemType>getItemType(@PathVariable int id)
    {

        return new ResponseEntity<ItemType>(itemService.getItemType(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/itemtype/get/all")
    public ResponseEntity<List<ItemType>>getAllItemType()
    {

        return new ResponseEntity<List<ItemType>>(itemService.getAllItemTypes(),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/item/add")
    public ResponseEntity<Items>addItem(@RequestBody Items items)
    {

        return new ResponseEntity<>(itemService.addItem(items), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/item/edit/{id}")
    public ResponseEntity<Items>editItem(@RequestBody Items items , @PathVariable int id)
    {
        return new ResponseEntity<>(itemService.updateItem(items,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/item/delete/{id}")
    public ResponseEntity<String>deleteItem(@PathVariable int id)
    {
        itemService.deleteItem(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/item/get/{id}")
    public ResponseEntity<Items>getItem(@PathVariable int id)
    {
        return new ResponseEntity<>(itemService.getItem(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/item/get/all")
    public ResponseEntity<List<Items>>getAllItems()
    {
        return new ResponseEntity<List<Items>>(itemService.getAllItems(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/author/add")
    public ResponseEntity<Author>addAuthor(@RequestBody Author author)
    {
       return new ResponseEntity<>(authorService.addAuthor(author),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/author/delete/{id}")
    public ResponseEntity<String>deleteAuthor(@PathVariable int id)
    {
        authorService.deleteAuthor(id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/author/get/{id}")
    public ResponseEntity<Author>getAuthor(@PathVariable int id)
    {
        return new ResponseEntity<>(authorService.getAuthor(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/author/edit/{id}")
    public ResponseEntity<Author>editAuthor(@RequestBody Author author , @PathVariable int id)
    {
        return new ResponseEntity<Author>(authorService.updateAuthor(author,id),HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/author/get/all")
    public ResponseEntity<List<Author>>getAllAuthors()
    {
        return new ResponseEntity<List<Author>>(authorService.getAllAuthors(),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/publisher/add")
    public ResponseEntity<Publisher>addPublisher(@RequestBody Publisher publisher)
    {
        return new ResponseEntity<>(publishlerService.addPublisher(publisher),HttpStatus.OK);

    }
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/publisher/delete/{id}")
    public ResponseEntity<String>deletePublisher(@PathVariable int id)
    {
        publishlerService.deletePublisher(id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/publisher/get/{id}")
    public ResponseEntity<Publisher>getPublisher(@PathVariable int id)
    {
        return new ResponseEntity<Publisher>(publishlerService.getPublisher(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/publisher/edit/{id}")
    public ResponseEntity<Publisher>editPublisher(@RequestBody Publisher publisher , int id)
    {
        return new ResponseEntity<>(publishlerService.updatePublisher(publisher,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/publisher/get/all")
    public ResponseEntity<List<Publisher>>getAllPublishers()
    {
        return new ResponseEntity<List<Publisher>>(publishlerService.getAllPublishers(),HttpStatus.OK);
    }


}
