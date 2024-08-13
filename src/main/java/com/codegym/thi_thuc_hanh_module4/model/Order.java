package com.codegym.thi_thuc_hanh_module4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Ngày mua không được để trống")
    @Future(message = "Ngày mua phải lớn hơn ngày hiện tại")
    private LocalDate day;
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    private Integer quantity;
    private Double totalPrice;
    @ManyToOne
    private Product product;

    public Double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
