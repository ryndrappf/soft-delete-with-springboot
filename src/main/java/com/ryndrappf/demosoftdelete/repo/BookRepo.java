package com.ryndrappf.demosoftdelete.repo;

import com.ryndrappf.demosoftdelete.entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Books, Long> {
}
