package com.example.demo.repos;

import com.example.demo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

    Book findByTitle(String title);


}
