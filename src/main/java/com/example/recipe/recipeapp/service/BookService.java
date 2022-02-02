package com.example.recipe.recipeapp.service;

import com.example.recipe.recipeapp.entity.Book;
import com.example.recipe.recipeapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> loadAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book loadBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public Book saveBook(Book book) {
        bookRepository.save(book);
        return loadBookById(book.getId());
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

}