package com.codegym.thi_thuc_hanh_module4.repository;

import com.codegym.thi_thuc_hanh_module4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE DATE(o.day) BETWEEN :startDate AND :endDate")
    List<Order> findOrdersByPurchaseDateBetween(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
