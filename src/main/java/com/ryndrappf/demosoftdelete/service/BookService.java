package com.ryndrappf.demosoftdelete.service;


import com.ryndrappf.demosoftdelete.entity.Books;
import com.ryndrappf.demosoftdelete.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public Books create(Books books){
        return bookRepo.save(books);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(){
        return bookRepo.findAll();
    }

}
