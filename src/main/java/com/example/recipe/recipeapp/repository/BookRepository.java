package com.example.recipe.recipeapp.repository;

import com.example.recipe.recipeapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
