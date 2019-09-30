package com.example.book.service;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;
import com.example.book.model.dto.ListOfPages;
import com.example.book.model.dto.PageDTO;

import java.util.ArrayList;
import java.util.List;

public interface IPageService {
    PageDTO savePage(PageEntityInput pagee);

    Page getPage(Long id);

    void deletePage(Long id);

    List<PageDTO> getPages();

    List<PageDTO> pagesbyId(Long bookID, ListOfPages pageList);

    Page updatePage(PageEntityInput pageEntityInput, Long ID);

    void deletePages();

}
