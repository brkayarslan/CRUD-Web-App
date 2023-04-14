package com.example.crudproject.service;

import com.example.crudproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(); //list
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
