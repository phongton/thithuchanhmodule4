package com.codegym.thi_thuc_hanh_module4.controller;


import com.codegym.thi_thuc_hanh_module4.model.Category;
import com.codegym.thi_thuc_hanh_module4.model.Order;
import com.codegym.thi_thuc_hanh_module4.service.ICategoryService;
import com.codegym.thi_thuc_hanh_module4.service.IOrderService;
import com.codegym.thi_thuc_hanh_module4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public String order(Model model) {
        List<Order> orders = orderService.findAll();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("orders", orders);
        model.addAttribute("category", categories);
        return "index";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("orders", order);
        model.addAttribute("category",categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProducts());
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Order order) {
        orderService.save(order);
        return "redirect:/home";
    }

}
