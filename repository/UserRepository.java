package com.example.api.repository;
import java.util.*;

import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {


    @Query(value = "select u " +
            "from User u")
    List<User> findAllUsers();

    @Query(value = "select bb " +
            "from User u " +
            "join BorrowBook bb on bb.user = u " +
            "where u.tcNo = :tcNo")
    List<BorrowBook> dueDates(@Param("tcNo") String tcNo);

    @Query(value = "CALL takeBook(:userId,:isbn,:dueDate);", nativeQuery = true)
    void borrowBook(@Param("userId") String userId, @Param("isbn") String isbn,
                    @Param("dueDate") Date dueDate);





}
