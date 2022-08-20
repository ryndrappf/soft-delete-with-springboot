package com.ryndrappf.demosoftdelete.controller;

import com.ryndrappf.demosoftdelete.entity.Books;
import com.ryndrappf.demosoftdelete.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public Books createOne(@RequestBody Books books){
        return bookService.create(books);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        bookService.remove(id);
    }

    @GetMapping
    public Iterable<Books> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted){
        return bookService.findAll(isDeleted);
    }
}
