package com.ryndrappf.demosoftdelete.service;


import com.ryndrappf.demosoftdelete.entity.Books;
import com.ryndrappf.demosoftdelete.repo.BookRepo;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private EntityManager entityManager;


    public Books create(Books books){
        return bookRepo.save(books);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(boolean isDeleted){
        //return bookRepo.findAll();
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Books> books = bookRepo.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    }



}
