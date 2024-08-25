package com.javaexplore.docker.compose.service.impl;

import com.javaexplore.docker.compose.dao.BookRepository;
import com.javaexplore.docker.compose.model.Book;
import com.javaexplore.docker.compose.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
