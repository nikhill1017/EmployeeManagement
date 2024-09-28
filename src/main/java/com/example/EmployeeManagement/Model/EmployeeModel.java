package com.example.EmployeeManagement.Model;

public class EmployeeModel {
    private int employee_id;

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private String employee_name;
    private String employee_email;
    private int salary;

    public EmployeeModel() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeModel(int employee_id, String employee_name, String employee_email, int salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.salary = salary;
    }
}
