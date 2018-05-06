package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService{

        void addItemType(String name);
        ItemType getItemType(int id);
        void deleteItemType(int id);
        List<ItemType> getAllItemTypes();
        void updateItemType(ItemType dto , int id);

        void addItem(Items item);
        void updateItem(Items item,int id);
        void deleteItem(int id);
        List<Items> getAllItems();
        Items getItem(int id);



        void addSubject(Subject subject);
        void updateSubject(Subject subject , int id);
        void deleteSubject(int id);
        Subject getSubject(int id);
        List<Subject> getAllSubjects();

}
