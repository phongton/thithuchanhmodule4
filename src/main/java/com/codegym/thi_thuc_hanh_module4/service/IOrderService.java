package com.codegym.thi_thuc_hanh_module4.service;

import com.codegym.thi_thuc_hanh_module4.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findById(Integer id);
    Order save(Order order);
}
