package com.hutech.demo.service;

import com.hutech.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;
    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public void addBook(Book book){
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updateBook) {
        books.stream().filter(book -> book.getId().equals(updateBook.getId()))
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updateBook.getTitle());
                    book.setAuthor(updateBook.getAuthor());
                });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
