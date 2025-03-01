package com.project.bookmanagement.repository;

import com.project.bookmanagement.model.Book;
import com.project.bookmanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book,String> {
}
