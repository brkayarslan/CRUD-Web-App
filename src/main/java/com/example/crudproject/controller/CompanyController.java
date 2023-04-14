package com.example.crudproject.controller;

import com.example.crudproject.model.Company;
import com.example.crudproject.repository.CompanyRepository;
import com.example.crudproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //display list of companys
    @GetMapping("/showAllCompanies")
    public String viewHomePage(Model model){
        model.addAttribute("listCompanies",companyService.getAllCompanies());
        return "index";
    }

    @GetMapping("/showNewCompanyForm")
    public String showNewCompanyForm(Model model){
        //create model attribute to bind form data
        Company company = new Company();
        //Thymeleaf şablonu, form verilerini bağlamak için bu boş company nesnesine erişecek
        //Thymeleaf template will access this company object for binding form data
        model.addAttribute("company",company);
        return "new_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company")Company company){
        //save company to database
        companyService.saveCompany(company);
        return "redirect:/";
    }

    @GetMapping("showFormForUpdateCompany/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")long id,Model model){
        //get company from the service
        Company company = companyService.getCompanyById(id);

        model.addAttribute("company",company);
        return "update_company";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value="id") long id){

        //call delete company method
        this.companyService.deleteCompanyById(id);
        return "redirect:/";
    }

}
