package com.codegym.thi_thuc_hanh_module4.service.impl;


import com.codegym.thi_thuc_hanh_module4.model.Order;
import com.codegym.thi_thuc_hanh_module4.model.Product;
import com.codegym.thi_thuc_hanh_module4.repository.IOrderRepository;
import com.codegym.thi_thuc_hanh_module4.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
