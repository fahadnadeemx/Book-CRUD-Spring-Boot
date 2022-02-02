package com.example.recipe.recipeapp.service;

import com.example.recipe.recipeapp.entity.Category;
import com.example.recipe.recipeapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> loadAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }
    public Category loadBookById(int id) {
        return categoryRepository.findById(id).get();
    }

    public Category saveBook(Category category) {
        categoryRepository.save(category);
        return loadBookById(category.getCid());
    }

    public void deleteBook(int id) {categoryRepository.deleteById(id);
    }

    public Category updateBook(Category category) {
        return categoryRepository.save(category);
    }


}
