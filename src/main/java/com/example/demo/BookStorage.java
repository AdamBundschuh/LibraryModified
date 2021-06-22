package com.example.demo;

import com.example.demo.repos.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookStorage {
    //1. Providing a way to save new books
    //2. Providing a way to retrieve a single book
    //3. Providing a way to retrieve all books
    //4. Provide error handling

    private BookRepository bookRepo; //links BookRepository Interface

    public BookStorage(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book retrieveBookByID(Long id) {
        return bookRepo.findById(id).get();
    }

    public Book retrieveBookByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

//    Retrieve Book By Title Using For Each Loop (not efficient)
//    public Book retreiveBookByTitle(String title) {
//
//        Iterable<Book> books = bookRepo.findAll();
//        for (Book book: books) {
//
//            if (book.getTitle().contains(title)) {
//                return book;
//            }
//
//        }
//        return null;
//    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    public void saveBook(Book bookToAdd) {
        bookRepo.save(bookToAdd);
    }

    public Iterable<Book> retrieveAllBooks() {
        return bookRepo.findAll();
    }

}
