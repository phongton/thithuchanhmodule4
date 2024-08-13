package com.codegym.thi_thuc_hanh_module4.repository;

import com.codegym.thi_thuc_hanh_module4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
