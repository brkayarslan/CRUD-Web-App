package com.example.crudproject.controller;

import com.example.crudproject.model.Company;
import com.example.crudproject.model.Employee;
import com.example.crudproject.repository.CompanyRepository;
import com.example.crudproject.service.CompanyService;
import com.example.crudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyRepository companyRepository;
    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("listCompanies",companyRepository.findAll());
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        Employee employee = new Employee();

        //Thymeleaf template will access this employee object for binding form data
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable (value = "id") long id, @ModelAttribute("employee") Employee employee){
        //save employee to database
        Employee existingEmployee = employeeService.getEmployeeById(id);

        //update the existing employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setCompany(employee.getCompany());

        //save the updated employee to the database
        employeeService.saveEmployee(existingEmployee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateEmployee/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        //get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){

        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
