package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
//        System.out.println("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeService.findAllEmployee();
        return new ModelAndView("index", "resultObject", Employees);
    }

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.POST)
    public ModelAndView searchEmployee(@PathVariable("searchText") String text) {
        System.out.println("EmployeeController searchEmployee is called");
        List<Employee> Employees = employeeService.searchEmployee(text);
        return new ModelAndView("index", "resultObject", Employees);
    }
}
