package com.javaexplore.docker.compose.service;

import com.javaexplore.docker.compose.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book saveBook(Book book);

    List<Book> getBooks();
}
