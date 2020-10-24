package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @Column(name="TC_NUMBER")
    private String tcNo;

    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<BorrowBook> books = new  HashSet<>();

    @Column(name="NUMBER_OF_BOOK")
    private Integer numOfBook;

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public Set<BorrowBook> getBooks() {
        return books;
    }

    public void setBooks(Set<BorrowBook> books) {
        this.books = books;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }
}
