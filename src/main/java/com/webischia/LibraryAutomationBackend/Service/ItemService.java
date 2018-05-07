package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService{

        ItemType addItemType(String name);
        ItemType getItemType(int id);
        void deleteItemType(int id);
        List<ItemType> getAllItemTypes();
        ItemType updateItemType(ItemType dto , int id);

        Items addItem(Items item);
        Items updateItem(Items item,int id);
        void deleteItem(int id);
        List<Items> getAllItems();
        Items getItem(int id);
        Items findItemByISBN(String ISBN);
        List<Items> searchItemByKeyword(String keyword);
        List<Items> searchItemsByPublisher(String publisher);
        List<Items> searchItemsByAuthor(String author);
        List<Items> searchItesmBySubject(String subject);

        Subject addSubject(Subject subject);
        Subject updateSubject(Subject subject , int id);
        void deleteSubject(int id);
        Subject getSubject(int id);
        List<Subject> getAllSubjects();

        void addAuthorToItem(int authorID , int itemID );
        void addSubjectToItem(int subjectID,int itemID) ;
        void addPublisherToItem(int publisherID,int itemID);
        void editAuthorToItem(int authorID,int itemID);
        void editSubjectToItem(int subjectid,int itemID);
        void editPublisherToItem(int publisherId,int itemID);
}
