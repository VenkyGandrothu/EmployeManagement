package com.employemanage.services;

import com.employemanage.dao.EmployeDao;
import com.employemanage.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeDao employeDao;

    // Save employee
    public int saveEmploye(Employe employe) {
        return employeDao.saveEmploye(employe);
    }

    // Update employee
    public int updateEmploye(Employe employe) {
        return employeDao.updateEmploye(employe);
    }

    // Delete employee
    public int deleteEmploye(int id) {
        return employeDao.deleteEmploye(id);
    }

    // Get all employees
    public List<Employe> getAllEmploye() {
        return employeDao.getAllEmploye();
    }

    // Get one employee by ID
    public Employe getOneEmploye(int id) {
        return employeDao.getOneEmploye(id);
    }
}