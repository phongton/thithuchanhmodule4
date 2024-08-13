package com.codegym.thi_thuc_hanh_module4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate day;
    private Integer quantity;
    private Double totalPrice;
    @ManyToOne
    private Product product;

    public Double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
