package com.example.recipe.recipeapp.controller;

import com.example.recipe.recipeapp.entity.Book;
import com.example.recipe.recipeapp.entity.Category;
import com.example.recipe.recipeapp.service.BookService;
import com.example.recipe.recipeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@RequestMapping("/index")
public class index {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

    @RequestMapping( method = RequestMethod.GET)
    private String getAllBooks(Model model) {
        List<Book> list = bookService.loadAllBooks();
        model.addAttribute("allBooks", list);

        List<Category> _list = categoryService.loadAllCategory();
        model.addAttribute("allCategory", _list);

        return "index";
    }
}
