package com.glasiem.istp_lab2.controller;

import com.glasiem.istp_lab2.model.Seller;
import com.glasiem.istp_lab2.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/seller")
    public String getSellers(Model model){

        model.addAttribute("sellers", sellerService.getSellerRepo().findAll());

        return "/sellers/seller";
    }

    @PostMapping("/insert/seller")
    public String insertSeller(@Valid Seller seller, RedirectAttributes redirectAttributes){

        if (sellerService.insertValid(seller) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + seller.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/seller")
    public String updateSeller(@Valid Seller seller, RedirectAttributes redirectAttributes){
        if (sellerService.updateValid(seller) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + seller.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/seller")
    public String deleteSeller(@Valid Seller seller, RedirectAttributes redirectAttributes){
        if (sellerService.deleteValid(seller.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + seller.getId());
            return "redirect:/response";
        }
    }
}
