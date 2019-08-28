package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Pagee;
import com.example.book.repository.BookRepository;
import com.example.book.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PageeService {

    private PageRepository pageRepository;
    private BookRepository bookRepository;

    @Autowired
    public PageeService(PageRepository pageRepository, BookRepository bookRepository) {
        this.pageRepository = pageRepository;
        this.bookRepository = bookRepository;
    }


    public Pagee savePage(PageEntityInput pagee) {
       Optional<Book> bookOptional =  bookRepository.getBookEntityById(pagee.getBookID());
       if(bookOptional.isPresent()){
           Pagee page2Save  = new Pagee();
           page2Save.setContent(pagee.getContent());
           page2Save.setOrdinalNumber(pagee.getOrdinalNumber());
           page2Save.setBook(bookOptional.get());
           return pageRepository.save(page2Save);

       }else  throw new IllegalAccessError("There is no book with that ID");
    }

    public Pagee getPage(Long id) {
        Optional<Pagee> pageeOptional = pageRepository.getPageEntityById(id);
        if(pageeOptional.isPresent())
        return pageRepository.getOne(id);
        else throw new IllegalStateException();
    }

}
