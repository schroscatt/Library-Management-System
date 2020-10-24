package com.example.api.service;

import com.example.api.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> findAll();

    Book insert(Book book);

    List<Book> findBook(String isbn, String title, String author);

    int delete(String isbn);
}
