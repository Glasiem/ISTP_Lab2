package com.glasiem.istp_lab2.controller;

import com.glasiem.istp_lab2.model.Owner;
import com.glasiem.istp_lab2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/owner")
    public String getOwners(Model model){

        model.addAttribute("owners", ownerService.getOwnerRepo().findAll());

        return "/owners/owner";
    }

    @PostMapping("/insert/owner")
    public String insertOwner(@Valid Owner owner, RedirectAttributes redirectAttributes){

        if (ownerService.insertValid(owner) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + owner.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/owner")
    public String updateOwner(@Valid Owner owner, RedirectAttributes redirectAttributes){
        if (ownerService.updateValid(owner) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + owner.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/owner")
    public String deleteOwner(@Valid Owner owner, RedirectAttributes redirectAttributes){
        if (ownerService.deleteValid(owner.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + owner.getId());
            return "redirect:/response";
        }
    }
}
