package com.example.recipe.recipeapp.controller;

import com.example.recipe.recipeapp.entity.Category;
import com.example.recipe.recipeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(path = "/savecategory", method = RequestMethod.POST)
    public String saveNewCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{Cid}")
    private String editCategory(@PathVariable("Cid") int Cid, Model model) {
        Category category = categoryService.loadCategoryById(Cid);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @RequestMapping(path = "/update/{Cid}", method = RequestMethod.POST)
    private String updateCategory(@PathVariable("Cid") int Cid, @ModelAttribute Category category) {
        category.setCid(Cid);
        categoryService.updateCategory(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{Cid}")
    private String deleteCategory(@PathVariable("Cid") int Cid) {
        categoryService.deleteCategory(Cid);
        return "redirect:/categories";
    }
}
