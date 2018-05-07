package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import com.webischia.LibraryAutomationBackend.Domains.Items;
import com.webischia.LibraryAutomationBackend.Domains.Subject;
import com.webischia.LibraryAutomationBackend.Repository.ItemRepository;
import com.webischia.LibraryAutomationBackend.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;
    SubjectRepository subjectRepository;

    public ItemServiceImpl(ItemRepository itemRepository, SubjectRepository subjectRepository) {
        this.itemRepository = itemRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public ItemType addItemType(String name) {
        return itemRepository.addItemType(name);
    }

    @Override
    public ItemType getItemType(int id) {
        return itemRepository.getItemType(id);
    }

    @Override
    public void deleteItemType(int id) {
        itemRepository.deleteItemType(id);
    }

    @Override
    public List<ItemType> getAllItemTypes() {
        return itemRepository.getAllItemTypes();
    }

    @Override
    public ItemType updateItemType(ItemType dto, int id) {
        return itemRepository.updateItemType(dto,id);
    }

    @Override
    public Items addItem(Items item) {
        return itemRepository.addItem(item,item.getTypeID());
    }

    @Override
    public Items updateItem(Items item, int id) {
        return itemRepository.updateItem(item,id);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteItem(id);
    }

    @Override
    public List<Items> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public Items getItem(int id) {

        return itemRepository.getItem(id);
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.addSubject(subject);
    }

    @Override
    public Subject updateSubject(Subject subject, int id) {
        return subjectRepository.updateSubject(subject,id);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepository.deleteSubject(id);
    }

    @Override
    public Subject getSubject(int id) {
        return subjectRepository.getSubject(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    @Override
    public void addAuthorToItem(int authorID, int itemID) {
        itemRepository.addAuthorToItem(authorID,itemID);
    }

    @Override
    public void addSubjectToItem(int subjectID, int itemID) {
        itemRepository.addSubjectToItem(subjectID,itemID);
    }

    @Override
    public void addPublisherToItem(int publisherID, int itemID) {
        itemRepository.addPublisherToItem(publisherID,itemID);

    }

    @Override
    public void editAuthorToItem(int authorID, int itemID) {
        itemRepository.editAuthorToItem(authorID,itemID);
    }

    @Override
    public void editSubjectToItem(int subjectid, int itemID) {
        itemRepository.editSubjectToItem(subjectid,itemID);
    }

    @Override
    public void editPublisherToItem(int publisherId, int itemID) {
        itemRepository.editPublisherToItem(publisherId,itemID);
    }

    @Override
    public Items findItemByISBN(String ISBN) {
        return itemRepository.findItemByISBN(ISBN);
    }

    @Override
    public List<Items> searchItemByKeyword(String keyword) {
        return itemRepository.searchItemByKeyword(keyword);
    }

    @Override
    public List<Items> searchItemsByPublisher(String publisher) {
        return itemRepository.searchItemsByPublisher(publisher);
    }

    @Override
    public List<Items> searchItemsByAuthor(String author) {
        return itemRepository.searchItemsByAuthor(author);
    }

    @Override
    public List<Items> searchItesmBySubject(String subject) {
        return searchItesmBySubject(subject);
    }
}
