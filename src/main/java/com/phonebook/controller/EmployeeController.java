package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
        System.out.println("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeService.findAllEmployee();
        return new ModelAndView("index", "resultObject", Employees);
    }

    @RequestMapping(value = "/{searchText}", method = RequestMethod.GET)
    public ModelAndView searchEmployee(@PathVariable("searchText") String searchText) {
        System.out.println("EmployeeController searchEmployee is called");
        List<Employee> Employees = employeeService.searchEmployee(searchText);
        return new ModelAndView("index", "resultObject", Employees);
    }
}
