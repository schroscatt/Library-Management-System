package com.example.api.service;

import com.example.api.dto.BorrowBookDTO;
import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import com.example.api.repository.BorrowBookRepository;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class BorrowBookServiceImp implements BorrowBookService {

    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(BorrowBook book){
        entityManager.createNativeQuery("INSERT INTO borrowbook (isbn, dueDate, receiver) VALUES (?,?,?)")
                .setParameter(1, book.getIsbn())
                .setParameter(2, book.getDueDate())
                .setParameter(3, book.getUser())
                .executeUpdate();
    }

    public List<BorrowBookDTO> findAllBorrows(){
        return this.borrowBookRepository.findAllBorrows();
    }

    public Date findDueDate(String isbn) {
        return this.borrowBookRepository.findDueDate(isbn);
    }

}
