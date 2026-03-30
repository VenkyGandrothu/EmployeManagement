package com.employemanage.controller;


import com.employemanage.dao.EmployeDao;
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
    private EmployeDao employeDao;

    @PostMapping("/save")
    public String addEmploye(Employe employe, RedirectAttributes redirectAttributes) {
        employeDao.saveEmploye(employe);
        redirectAttributes.addFlashAttribute("message", "Employee added successfully!");
        return "redirect:/listEmployees"; //jsp name
    }

    @DeleteMapping("/removeEmploye")
    public String deleteEmploye(@PathVariable("id") int id ){
        employeDao.deleteEmploye(id);
        return "redirect:/listEmployees";
    }

    @GetMapping("/")
    public String showAllEmployes(Model model){
        List<Employe> employes  = employeDao.getAllEmploye();
        model.addAttribute("allEmployees", employes);
        return "employeeList";
    }

}
