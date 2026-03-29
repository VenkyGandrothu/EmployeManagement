package com.employemanage.model;

public class Employe {

    private int empId;
    private String empName;
    private String role;
    private int salary;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employe(int empId, int salary, String empName, String role) {
        this.empId = empId;
        this.salary = salary;
        this.empName = empName;
        this.role = role;
    }

    public Employe(){
    }
}
