package com.employemanage.model;

public class Employe {

    private int empId;
    private String empName;
    private String empRole;
    private int empSalary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public Employe(int empId, int empSalary, String empName, String role) {
        this.empId = empId;
        this.empSalary = empSalary;
        this.empName = empName;
        this.empRole = role;
    }

    public Employe(){
    }
}
