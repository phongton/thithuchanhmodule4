package com.codegym.thi_thuc_hanh_module4.repository;

import com.codegym.thi_thuc_hanh_module4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
