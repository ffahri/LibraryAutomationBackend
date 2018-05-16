package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.*;

import java.util.List;


public interface ItemService{

        ItemType addItemType(String name);
        ItemType getItemType(int id);
        void deleteItemType(int id);
        List<ItemType> getAllItemTypes();
        ItemType updateItemType(ItemType dto , int id);

        Stock addStock(Stock stock);
        Stock editStock(Stock stock);
        Stock getStock(int id);
        void deleteStock(int id);
        List<Stock> getAllStockByItemID(int id);


        Items addItem(ItemDTO itemDTO);
        Items updateItem(ItemDTO itemDTO,int id);
        void deleteItem(int id);
        List<Items> getAllItems();
        Items getItem(int id);
        Items findItemByISBN(String ISBN);
        ItemDTO getItemDTO(int id);

        List<Items> searchItemByKeyword(String keyword);
        List<Items> searchItemsByPublisher(int publisherID);
        List<Items> searchItemsByAuthorID(int authorID);
        List<Items> searchItesmBySubject(String subject);
        List<Items> searchItemsByPost(Search search);

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
