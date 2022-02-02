package com.example.recipe.recipeapp.controller;

import com.example.recipe.recipeapp.entity.Book;
import com.example.recipe.recipeapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping( method = RequestMethod.GET)
    private String getAllBooks(Model model) {
        List<Book> list = bookService.loadAllBooks();
        model.addAttribute("allBooks", list);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewBookPage(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveNewBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    private String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.loadBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateBook(@PathVariable("id") int id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    private String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}