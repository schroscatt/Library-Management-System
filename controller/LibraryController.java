package com.example.api.controller;


import com.example.api.dto.BorrowBookDTO;
import com.example.api.model.Book;
import com.example.api.model.BorrowBook;
import com.example.api.model.User;
import com.example.api.service.BookService;
import com.example.api.service.BorrowBookService;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowBookService borrowBookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.findAll();
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return this.bookService.insert(book);
    }

    @PostMapping("books/find")
    public List<Book> findBooks(@RequestParam String isbn, @RequestParam String title,
                                @RequestParam String author) {
        return this.bookService.findBook(isbn,title,author);

    }

    @PostMapping("books/delete/{isbn}")
    public int deleteBook(@PathVariable String isbn) {
        return this.bookService.delete(isbn);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.findAllUsers();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/borrows")
    public List<BorrowBookDTO> getAllBorrows(){
        return this.borrowBookService.findAllBorrows();
    }

    @PostMapping("/borrow-book/{userID}/{isbn}")
    public String borrowBook(@PathVariable String userID, @PathVariable String isbn) {
        return this.userService.borrowBook(userID, isbn);
    }

    @GetMapping("/return-book/{isbn}")
    public String returnBook(@PathVariable String isbn){
        return userService.returnBook(isbn);
    }

    @GetMapping("/due/{isbn}")
    public Date findDue(@PathVariable String isbn) {
        return this.borrowBookService.findDueDate(isbn);
    }

    @GetMapping("/userbooks/{tcNo}")
    public List<BorrowBook> getDueDates(@PathVariable String tcNo) {
        return this.userService.getDueDates(tcNo);
    }
}
