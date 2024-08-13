package com.codegym.thi_thuc_hanh_module4.controller;


import com.codegym.thi_thuc_hanh_module4.model.Category;
import com.codegym.thi_thuc_hanh_module4.model.Order;
import com.codegym.thi_thuc_hanh_module4.service.ICategoryService;
import com.codegym.thi_thuc_hanh_module4.service.IOrderService;
import com.codegym.thi_thuc_hanh_module4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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
    public String edit(@Validated @ModelAttribute("orders") Order order, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("orders", order);
            model.addAttribute("category",categoryService.getAllCategory());
            model.addAttribute("products", productService.getAllProducts());
            return "edit";
        }
        orderService.save(order);
        redirectAttributes.addFlashAttribute("message","Sửa thành công");
        return "redirect:/home";
    }
    @PostMapping("/search")
    public String search(@RequestParam LocalDate startDate,
                         @RequestParam LocalDate endDate,Model model) {
        model.addAttribute("orders",orderService.findAllByDay(startDate,endDate));
        return "index";
    }

}
