package com.employemanage.controller;

import com.employemanage.services.EmployeService;
import com.employemanage.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/save")
    public String addEmploye(Employe employe, RedirectAttributes redirectAttributes) {
        employeService.saveEmploye(employe);
        redirectAttributes.addFlashAttribute("message", "Employee added successfully!");
        return "redirect:/listEmployees";
    }

    @DeleteMapping("/removeEmploye/{id}")
    public String deleteEmploye(@PathVariable("id") int id ){
        employeService.deleteEmploye(id);
        return "redirect:/listEmployees";
    }

    @GetMapping("/")
    public String showAllEmployes(Model model){
        List<Employe> employes  = employeService.getAllEmploye();
        model.addAttribute("allEmployees", employes);
        return "employeeList";
    }

    @GetMapping("/getEmployeById/{id}")
    @ResponseBody // Because you are returning JSON object
    public Employe showEmployeById(@PathVariable("id") int id){
        return employeService.getOneEmploye(id);
    }
}
