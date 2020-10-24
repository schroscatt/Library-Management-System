package com.example.api.service;

import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import java.util.*;

import com.example.api.repository.BorrowBookRepository;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> findAllUsers(){
        return this.userRepository.findAllUsers();
    }

    @Transactional
    public User insert(User user){
        entityManager.createNativeQuery("INSERT INTO users VALUES (?,?)")
                .setParameter(1, user.getTcNo())
                .setParameter(2, 0)
                .executeUpdate();

        return user;
    }
    public List<BorrowBook> getDueDates(String tcNo){
        return userRepository.dueDates(tcNo);
    }

    public String borrowBook(String tcNo, String isbn){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_MONTH, 2);
        Date dueDate = c.getTime();
        this.userRepository.borrowBook(tcNo,isbn,dueDate);
        return "Taken";
    }

    public String returnBook(String isbn) {
        this.borrowBookRepository.delete(isbn);
        return "Returned";
    }

}
