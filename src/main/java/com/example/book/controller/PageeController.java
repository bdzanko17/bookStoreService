package com.example.book.controller;

import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Pagee;
import com.example.book.service.PageeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageeController {

    private PageeService service;


    @Autowired
    public PageeController(PageeService service) {
        this.service = service;
    }

    @PostMapping("/savePage")
    public Pagee save (@RequestBody PageEntityInput pagee){
        return service.savePage(pagee);

    }

    @GetMapping(path = "/page/{id}")
    public Pagee getPageByID(@PathVariable Long  id){
        return service.getPage(id);
    }


}
