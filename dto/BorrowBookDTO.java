package com.example.api.dto;

import java.util.Date;

public class BorrowBookDTO {
    String isbn;
    Date dueDate;
    String userId;

    public BorrowBookDTO(String isbn, Date dueDate, String userId) {
        this.isbn = isbn;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
