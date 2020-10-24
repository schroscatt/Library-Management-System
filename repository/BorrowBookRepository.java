package com.example.api.repository;
import com.example.api.dto.BorrowBookDTO;
import com.example.api.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface BorrowBookRepository extends JpaRepository<BorrowBook,String> {
    @Query(value = "select new com.example.api.dto.BorrowBookDTO(" +
            "bb.isbn," +
            "bb.dueDate," +
            "bb.user.tcNo) " +
            "from BorrowBook bb")
    List<BorrowBookDTO> findAllBorrows();


    @Query(value = "select bb.dueDate " +
            "from BorrowBook bb " +
            "where bb.isbn = :isbn")
    Date findDueDate(@Param("isbn") String isbn);


    @Transactional
    @Modifying
    @Query(value = "delete from BorrowBook bb where bb.isbn = :isbn")
    int delete(@Param("isbn") String isbn);
}

