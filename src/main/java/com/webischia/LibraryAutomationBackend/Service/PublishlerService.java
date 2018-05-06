package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublishlerService {


    Publisher addPublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher,int id);
    void deletePublisher(int id);
    List<Publisher> getAllPublishers();
    Publisher getPublisher(int id);
}
