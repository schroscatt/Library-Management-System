package com.example.api.service;
import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface UserService {

    List<User> findAllUsers();

    List<BorrowBook> getDueDates(String tcNo);

    User insert(User user);

    String borrowBook(String tcNo, String isbn);

    String returnBook(String isbn);
}


