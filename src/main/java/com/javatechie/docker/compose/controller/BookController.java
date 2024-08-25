package com.javatechie.docker.compose.controller;

import com.javatechie.docker.compose.dao.BookRepository;
import com.javatechie.docker.compose.model.Book;
import com.javatechie.docker.compose.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping(value = "/getBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}
