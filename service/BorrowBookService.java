package com.example.api.service;

import com.example.api.dto.BorrowBookDTO;
import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface BorrowBookService {

    List<BorrowBookDTO> findAllBorrows();

    Date findDueDate(String isbn);

    void insert(BorrowBook book);


}
