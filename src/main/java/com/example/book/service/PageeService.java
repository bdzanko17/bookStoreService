//package com.example.book.service;
//
//import com.example.book.model.Pagee;
//import com.example.book.repository.BookRepository;
//import com.example.book.repository.PageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PageeService {
//
//private PageRepository pageRepository;
//private BookRepository bookRepository;
//
//    @Autowired
//    public PageeService(PageRepository pageRepository, BookRepository bookRepository) {
//        this.pageRepository = pageRepository;
//        this.bookRepository = bookRepository;
//    }
//
//    public Pagee savePage(Long ordinalNumber, String content) {
//        Pagee pagee = new Pagee(ordinalNumber, content);
//        return pageRepository.save(pagee);
//    }
//    public Pagee updatePageById(Long bookID,Long  pageID){
//        Optional<Pagee> pageOptional=pageRepository.getPageEntityById(pageID);
//        if(pageOptional.isPresent()){
//            pageOptional.get().setBookId(bookID);
//            pageRepository.save(new Pagee(pageOptional.get().getId(),pageOptional.get().getOrdinalNumber(),pageOptional.get().getContent(),pageOptional.get().getBookId()));
//            return new Pagee(pageOptional.get().getId(),pageOptional.get().getOrdinalNumber(),pageOptional.get().getContent(),pageOptional.get().getBookId());
//        }else {
//            throw new IllegalArgumentException("bad");
//        }
//
//    }
//
//    public Pagee getPage(Long id) {
//        return pageRepository.getOne(id);
//    }
//
//}
