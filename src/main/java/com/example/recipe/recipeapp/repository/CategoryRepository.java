package com.example.recipe.recipeapp.repository;

import com.example.recipe.recipeapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
