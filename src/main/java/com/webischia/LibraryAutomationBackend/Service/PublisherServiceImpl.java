package com.webischia.LibraryAutomationBackend.Service;

import com.webischia.LibraryAutomationBackend.Domains.Publisher;
import com.webischia.LibraryAutomationBackend.Repository.PublishlerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements PublishlerService {

    PublishlerRepository publishlerRepository;

    public PublisherServiceImpl(PublishlerRepository publishlerRepository) {
        this.publishlerRepository = publishlerRepository;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publishlerRepository.addPublisher(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher, int id) {

        return publishlerRepository.updatePublisher(publisher,id);
    }

    @Override
    public void deletePublisher(int id) {
        publishlerRepository.deletePublisher(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {

        return publishlerRepository.getAllPublishers();
    }

    @Override
    public Publisher getPublisher(int id) {

        return publishlerRepository.getPublisher(id);
    }
}
