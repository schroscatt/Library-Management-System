package com.example.api.service;

import com.example.api.model.Book;
import com.example.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Transactional
    public Book insert(Book book){
        entityManager.createNativeQuery("INSERT INTO book (isbn, title, author, status) VALUES (?,?,?,?)")
                .setParameter(1, book.getIsbn())
                .setParameter(2, book.getTitle())
                .setParameter(3, book.getAuthor())
                .setParameter(4, false)
                .executeUpdate();
        return book;
    }

    public List<Book> findBook(String isbn, String title, String author) {
        if(isbn.isEmpty()) isbn=null;
        if(title.isEmpty()) title = null;
        if(author.isEmpty()) author = null;
        return bookRepository.findBook(isbn, title, author);
    }

    public int delete(String isbn) {
        return this.bookRepository.delete(isbn);
    }

}
