package com.codegym.thi_thuc_hanh_module4.repository;

import com.codegym.thi_thuc_hanh_module4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
