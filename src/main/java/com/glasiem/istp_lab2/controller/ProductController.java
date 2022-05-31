package com.glasiem.istp_lab2.controller;

import com.glasiem.istp_lab2.model.Product;
import com.glasiem.istp_lab2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public String getProducts(Model model){

        model.addAttribute("products", productService.getProductRepo().findAll());

        return "/products/product";
    }

    @PostMapping("/insert/product")
    public String insertProduct(@Valid Product product, RedirectAttributes redirectAttributes){

        if (productService.insertValid(product) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + product.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/product")
    public String updateProduct(@Valid Product product, RedirectAttributes redirectAttributes){
        if (productService.updateValid(product) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + product.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/product")
    public String deleteProduct(@Valid Product product, RedirectAttributes redirectAttributes){
        if (productService.deleteValid(product.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + product.getId());
            return "redirect:/response";
        }
    }
}
