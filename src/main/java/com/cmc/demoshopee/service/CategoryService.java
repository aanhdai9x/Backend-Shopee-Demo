package com.cmc.demoshopee.service;

import com.cmc.demoshopee.entity.exam.Category;
import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Integer categoryId);
    public void deleteCategory(Integer categoryId);
}
