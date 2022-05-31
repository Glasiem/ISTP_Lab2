package com.glasiem.istp_lab2.controller;

import com.glasiem.istp_lab2.model.Shop;
import com.glasiem.istp_lab2.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShopController {

    @GetMapping("/")
    public String getPage(){
        return "redirect:/shop";
    }

    @GetMapping("/response")
    public String getResponse(){
        return "security/response";
    }

    @Autowired
    ShopService shopService;

    @GetMapping("/shop")
    public String getShops(Model model){

        model.addAttribute("shops", shopService.getShopRepo().findAll());

        return "/shops/shop";
    }

    @PostMapping("/insert/shop")
    public String insertShop(@Valid Shop shop, RedirectAttributes redirectAttributes){

        if (shopService.insertValid(shop) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + shop.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/shop")
    public String updateShop(@Valid Shop shop, RedirectAttributes redirectAttributes){
        if (shopService.updateValid(shop) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + shop.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/shop")
    public String deleteShop(@Valid Shop shop, RedirectAttributes redirectAttributes) {
        if (shopService.deleteValid(shop.getId()) == 1) {
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        } else {
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + shop.getId());
            return "redirect:/response";
        }
    }
}
