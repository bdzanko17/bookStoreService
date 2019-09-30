package com.example.book.controller;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;
import com.example.book.model.dto.ListOfPages;
import com.example.book.model.dto.PageDTO;
import com.example.book.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pages")
@CrossOrigin(origins = "http://localhost:4200")
public class PageController {

    private IPageService service;

    @Autowired
    public PageController(IPageService service) {
        this.service = service;
    }

    @PostMapping
    public PageDTO save(@RequestBody PageEntityInput pagee) {
        return service.savePage(pagee);
    }

    @DeleteMapping
    public void deletePages() {
        service.deletePages();
    }

    @GetMapping("/{id}")
    public Page getPageByID(@PathVariable Long id) {
        return service.getPage(id);
    }

    @DeleteMapping("/{id}")
    public void deletePage(@PathVariable String id) {
        service.deletePage(Long.parseLong(id));
    }

    @PutMapping(path = "/{id}")
    public Page updatePage(@PathVariable String id, @RequestBody PageEntityInput pageEntityInput) {
        return service.updatePage(pageEntityInput, Long.parseLong(id));
    }

    @GetMapping("/bookPages/{id}")
    public List<PageDTO> getPages(@PathVariable String id, @RequestBody ListOfPages longArrayList) {
        return service.pagesbyId(Long.valueOf(id), longArrayList);
    }

    @GetMapping
    public List<PageDTO> getPages() {
        return service.getPages();
    }

}
