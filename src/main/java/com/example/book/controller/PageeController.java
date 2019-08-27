//package com.example.book.controller;
//
//import com.example.book.model.Pagee;
//import com.example.book.service.PageeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class PageeController {
//
//    private PageeService service;
//
//
//    @Autowired
//    public PageeController(PageeService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/savePage")
//    public Pagee save (@RequestParam Long ordinalNumber, @RequestParam String content){
//        return service.savePage(ordinalNumber,content);
//    }
//    @PostMapping("/addPage")
//    public Pagee addPageToBook(@RequestParam Long bookID,@RequestParam Long pageID){
//        return service.updatePageById(bookID,pageID);
//    }
//    @GetMapping(path = "/page/{id}")
//    public Pagee getPageByID(@PathVariable Long  id){
//        return service.getPage(id);
//    }
//
//
//}
