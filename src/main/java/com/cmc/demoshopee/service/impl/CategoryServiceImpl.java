package com.cmc.demoshopee.service.impl;

import com.cmc.demoshopee.entity.exam.Category;
import com.cmc.demoshopee.repository.CategoryRepository;
import com.cmc.demoshopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
    }
}
