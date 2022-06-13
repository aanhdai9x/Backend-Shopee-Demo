package com.cmc.demoshopee.repository;

import com.cmc.demoshopee.entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
