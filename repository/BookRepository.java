package com.example.api.repository;

import com.example.api.model.Book;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


public interface BookRepository extends JpaRepository<Book,String> {
    @Query(value = "select b " +
            "from Book b")
    List<Book> findAll();

    @Transactional
    @Modifying
    @Query(value = "delete from Book b where b.isbn = :isbn")
    int delete(@Param("isbn") String isbn);


    @Query(value = "select b from Book b " +
            "where (:isbn is null or b.isbn = :isbn ) " +
            "and (:title is  null or b.title = :title) " +
            "and (:author is null or b.author = :author)")
    List<Book> findBook(@Param("isbn") String isbn,@Param("title") String title, @Param("author") String author);
}
