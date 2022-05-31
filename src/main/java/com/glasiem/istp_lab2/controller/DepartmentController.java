package com.glasiem.istp_lab2.controller;

import com.glasiem.istp_lab2.model.Department;
import com.glasiem.istp_lab2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/department")
    public String getDepartments(Model model){

        model.addAttribute("departments", departmentService.getDepartmentRepo().findAll());

        return "/departments/department";
    }

    @PostMapping("/insert/department")
    public String insertDepartments(@Valid Department department, RedirectAttributes redirectAttributes){

        if (departmentService.insertValid(department) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + department.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/department")
    public String updateDepartments(@Valid Department department, RedirectAttributes redirectAttributes){
        if (departmentService.updateValid(department) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + department.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/department")
    public String deleteDepartments(@Valid Department department, RedirectAttributes redirectAttributes){
        if (departmentService.deleteValid(department.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + department.getId());
            return "redirect:/response";
        }
    }
}
