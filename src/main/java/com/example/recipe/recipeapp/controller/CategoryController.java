package com.example.recipe.recipeapp.controller;

import com.example.recipe.recipeapp.entity.Category;
import com.example.recipe.recipeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    private String getAllcategory(Model model) {
        List<Category> list = categoryService.loadAllCategory();
        model.addAttribute("allCategory", list);
        return "category";
    }
    @RequestMapping("/newcategory")
    public String showNewCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "add-category";
    }


}