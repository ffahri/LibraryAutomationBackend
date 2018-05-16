package com.webischia.LibraryAutomationBackend.Controllers;

import com.webischia.LibraryAutomationBackend.Domains.*;
import com.webischia.LibraryAutomationBackend.Service.AuthorService;
import com.webischia.LibraryAutomationBackend.Service.ItemService;
import com.webischia.LibraryAutomationBackend.Service.PublishlerService;
import com.webischia.LibraryAutomationBackend.Service.UserService;
import oracle.jdbc.proxy.annotation.Post;
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
    private  final UserService userService;

    public ManagementController(ItemService itemService, PublishlerService publishlerService, AuthorService authorService, UserService userService) {
        this.itemService = itemService;
        this.publishlerService = publishlerService;
        this.authorService = authorService;
        this.userService = userService;
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
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")

    @GetMapping("/itemtype/get/{id}")
    public ResponseEntity<ItemType>getItemType(@PathVariable int id)
    {

        return new ResponseEntity<ItemType>(itemService.getItemType(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")

    @GetMapping("/itemtype/get/all")
    public ResponseEntity<List<ItemType>>getAllItemType()
    {

        return new ResponseEntity<List<ItemType>>(itemService.getAllItemTypes(),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/item/add")
    public ResponseEntity<Items>addItem(@RequestBody ItemDTO itemDTO)
    {

        return new ResponseEntity<>(itemService.addItem(itemDTO), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/item/edit/{id}")
    public ResponseEntity<Items>editItem(@RequestBody ItemDTO itemDTO , @PathVariable int id)
    {
        return new ResponseEntity<>(itemService.updateItem(itemDTO,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")

    @GetMapping("/item/delete/{id}")
    public ResponseEntity<String>deleteItem(@PathVariable int id)
    {
        itemService.deleteItem(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")

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
    @PostMapping("/item/stock/add")
    public ResponseEntity<Stock>postStock(@RequestBody Stock stock)
    {
        return new ResponseEntity<Stock>(itemService.addStock(stock),HttpStatus.OK);
    }
    @GetMapping("/item/stock/get/{id}")
    public ResponseEntity<Stock>showStock(@PathVariable int id)
    {
        return new ResponseEntity<Stock>(itemService.getStock(id),HttpStatus.OK);
    }
    @GetMapping("/item/itemdto/get/{itemid}")
    public ResponseEntity<ItemDTO>getITEMDTO(@PathVariable int itemid)
    {
        return new ResponseEntity<ItemDTO>(itemService.getItemDTO(itemid),HttpStatus.OK);
    }
    @GetMapping("/item/stock/item/{id}")
    public ResponseEntity<List<Stock>>showAllStockByItemid(@PathVariable int id)
    {
        return new ResponseEntity<List<Stock>>(itemService.getAllStockByItemID(id),HttpStatus.OK);
    }
    @PostMapping("/item/stock/edit/")
    public ResponseEntity<Stock>editStock(@RequestBody Stock stock)
    {
        return new ResponseEntity<Stock>(itemService.editStock(stock),HttpStatus.OK);
    }
    @PostMapping("/item/stock/delete/{id}")
    public ResponseEntity<String>deleteStock(@PathVariable int id)
    {
        itemService.deleteStock(id);
        return new ResponseEntity<String>(HttpStatus.OK);
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

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
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
    public ResponseEntity<Publisher>editPublisher(@RequestBody Publisher publisher , @PathVariable int id)
    {
        publisher.setPublisherID(id);
        System.out.println("PUBLISHERID "+publisher.getPublisherID());
        return new ResponseEntity<>(publishlerService.updatePublisher(publisher,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")

    @GetMapping("/publisher/get/all")
    public ResponseEntity<List<Publisher>>getAllPublishers()
    {
        return new ResponseEntity<List<Publisher>>(publishlerService.getAllPublishers(),HttpStatus.OK);
    }

    /////////////
    @PreAuthorize("hasAuthority('Admin')")

    @PostMapping("/subject/add")
    public ResponseEntity<Subject>addSubject(@RequestBody Subject subject)
    {
        return new ResponseEntity<>(itemService.addSubject(subject),HttpStatus.OK);

    }
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/subject/delete/{id}")
    public ResponseEntity<String>deleteSubject(@PathVariable int id)
    {
        itemService.deleteSubject(id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/subject/get/{id}")
    public ResponseEntity<Subject>getSubject(@PathVariable int id)
    {
        return new ResponseEntity<Subject>(itemService.getSubject(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/subject/edit/{id}")
    public ResponseEntity<Subject>editSubject(@RequestBody Subject subject ,@PathVariable int id)
    {
        return new ResponseEntity<>(itemService.updateSubject(subject,id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")

    @GetMapping("/subject/get/all")
    public ResponseEntity<List<Subject>>getAllSubjects()
    {
        return new ResponseEntity<List<Subject>>(itemService.getAllSubjects(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/author/{authorid}")
    public ResponseEntity<Void>addAuthorToItem(@PathVariable int itemid , @PathVariable int authorid)
    {
        itemService.addAuthorToItem(authorid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/subject/{subjectid}")
    public ResponseEntity<Void>addSubjectToItem(@PathVariable int itemid , @PathVariable int subjectid)
    {
        itemService.addSubjectToItem(subjectid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/publisher/{publisherid}")
    public ResponseEntity<Void>addPublisherToItem(@PathVariable int itemid , @PathVariable int publisherid)
    {
        itemService.addPublisherToItem(publisherid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    ///
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/author/{authorid}/edit")
    public ResponseEntity<Void>editAuthorToItem(@PathVariable int itemid , @PathVariable int authorid)
    {
        itemService.editAuthorToItem(authorid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/subject/{subjectid}/edit")
    public ResponseEntity<Void>editSubjectToItem(@PathVariable int itemid , @PathVariable int subjectid)
    {
        itemService.editSubjectToItem(subjectid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/item/{itemid}/publisher/{publisherid}/edit")
    public ResponseEntity<Void>editPublisherToItem(@PathVariable int itemid , @PathVariable int publisherid)
    {
        itemService.editPublisherToItem(publisherid,itemid);
        return new ResponseEntity<Void>(HttpStatus.OK);
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

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @GetMapping("/borrows/{userID}")
    public ResponseEntity<List<Borrows>>aktifleriList(@PathVariable int userID)
    {
        return new ResponseEntity<List<Borrows>>(userService.aktifleriListele(userID),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @PostMapping("/borrows/odunc")
    public ResponseEntity<List<Borrows>>oduncVer(@RequestBody Borrows borrows)
    {
        int userID = userService.mailtoID(borrows.getMail());
        userService.oduncAl(borrows,userID);
        return new ResponseEntity<List<Borrows>>(userService.aktifleriListele(userID),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @PostMapping("/borrows/iade")
    public ResponseEntity<List<Borrows>>iadeAl(@RequestBody Borrows borrows)
    {
        userService.iadeAl(borrows);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @PostMapping("/mailtoid")
    public ResponseEntity<Borrows>mailtoID(@RequestBody Borrows borrows)
    {
        int userID = userService.mailtoID(borrows.getMail());
        System.out.println(userID +" geldi");
        Borrows tmp =new Borrows();
        tmp.setUserID(userID);
        return new ResponseEntity<Borrows>(tmp,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @GetMapping("/borrows/uzat/{stockID}")
    public ResponseEntity<Borrows>iadeAl(@PathVariable int stockID)
    {
        userService.uzat(stockID);
        Borrows tmp = new Borrows();
        return new ResponseEntity<>(tmp,HttpStatus.OK);
    }


}
