package com.example.recipe.recipeapp.controller;

import com.example.recipe.recipeapp.entity.Category;
import com.example.recipe.recipeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    private String getAllCategory(Model model) {
        List<Category> list = categoryService.loadAllCategory();
        model.addAttribute("allCategory", list);
//        return "categories";
        return "categories";
    }
    @RequestMapping("/new")
    public String showNewCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "add-category";
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveNewCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    private String editCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.loadCategoryById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateCategory(@PathVariable("id") int id, @ModelAttribute Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    private String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
