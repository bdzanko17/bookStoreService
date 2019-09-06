package com.example.book.controller;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;
import com.example.book.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {

    private IPageService service;

    @Autowired
    public PageController(IPageService service) {
        this.service = service;
    }

    @PostMapping
    public Page save(@RequestBody PageEntityInput pagee) {
        return service.savePage(pagee);
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

    @GetMapping
    public List<Page> getPages() {
        return service.getPages();
    }

}
