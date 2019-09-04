package com.example.book.service;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;

import java.util.List;

public interface IPageService {
    public Page savePage(PageEntityInput pagee);

    public Page getPage(Long id);

    public void deletePage(Long id);

    public List<Page> getPages();
}
