package com.example.book.service;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;

import java.util.List;

public interface IPageService {
    Page savePage(PageEntityInput pagee);

    Page getPage(Long id);

    void deletePage(Long id);

    List<Page> getPages();

    Page updatePage(PageEntityInput pageEntityInput, Long ID);

    void deletePages();
}
