package com.example.book.service.impl;

import com.example.book.exceptions.BookNotFoundException;
import com.example.book.exceptions.PageNotFoundException;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;
import com.example.book.model.dto.ListOfPages;
import com.example.book.model.dto.PageDTO;
import com.example.book.repository.BookRepository;
import com.example.book.repository.PageRepository;
import com.example.book.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PageService implements IPageService {

    private PageRepository pageRepository;
    private BookRepository bookRepository;

    @Autowired
    public PageService(PageRepository pageRepository, BookRepository bookRepository) {
        this.pageRepository = pageRepository;
        this.bookRepository = bookRepository;
    }


    public PageDTO savePage(PageEntityInput pagee) {
        System.out.println(pagee.getBook());
        Optional<Book> bookOptional = bookRepository.getBookEntityById(pagee.getBook().getId());
        if (bookOptional.isPresent()) {
            Page page2Save = new Page();
            page2Save.setContent(pagee.getContent());
            page2Save.setOrdinalNumber(pagee.getOrdinalNumber());
            page2Save.setBook(bookOptional.get());
            return new PageDTO(pageRepository.save(page2Save));

        } else throw new BookNotFoundException();
    }

    public Page getPage(Long id) {
        Optional<Page> pageeOptional = pageRepository.getPageEntityById(id);
        if (pageeOptional.isPresent())
            return pageRepository.getOne(id);
        else throw new PageNotFoundException();
    }

    @Override
    public void deletePage(Long id) {
        pageRepository.delete(pageRepository.getOne(id));
    }

    @Override
    public List<PageDTO> getPages() {
        ArrayList<Page> pages = new ArrayList<>((int) pageRepository.count());
        ArrayList<PageDTO> pagesDto = new ArrayList<>((int) pageRepository.count());
        pageRepository.findAll().forEach(pages::add);
        for (Page page : pages) {
            if (page.getId() != null)
                pagesDto.add(new PageDTO(page));
        }
        return pagesDto;
    }
    @Override
    public List<PageDTO> pagesbyId(Long bookID, ListOfPages pageList) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(bookID);
        List<PageDTO> pages = new ArrayList<>();
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            for(Page page : book.getPages()){
                for(Long id :pageList.getList()){
                    if(page.getId().equals(id)){
                        pages.add(new PageDTO(page));
                    }
                }
            }
        }
        return pages;
    }

    @Override
    public Page updatePage(PageEntityInput pageEntityInput, Long ID) {
        Optional<Page> pageOptional = pageRepository.getPageEntityById(ID);

        if (pageOptional.isPresent()) {
            pageOptional.get().setContent(pageEntityInput.getContent());
            pageOptional.get().setOrdinalNumber(pageEntityInput.getOrdinalNumber());
        } else {
            throw new PageNotFoundException();
        }
        return pageRepository.save(pageOptional.get());
    }

    @Override
    public void deletePages() {
        pageRepository.deleteAll();
    }


}
