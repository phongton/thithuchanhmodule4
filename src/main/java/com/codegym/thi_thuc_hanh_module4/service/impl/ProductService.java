package com.codegym.thi_thuc_hanh_module4.service.impl;

import com.codegym.thi_thuc_hanh_module4.model.Product;
import com.codegym.thi_thuc_hanh_module4.repository.IProductRepository;
import com.codegym.thi_thuc_hanh_module4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
