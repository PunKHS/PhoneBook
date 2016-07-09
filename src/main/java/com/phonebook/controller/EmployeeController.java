package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
        System.out.println("ORMController findAllEmployee is called");
        List<Employee> Employees = employeeService.findAllEmployee();
        return new ModelAndView("index", "resultObject", Employees);
    }

//    @RequestMapping(value = "/queryFindByIdEmployee/{id}", method = RequestMethod.GET)
//    public ModelAndView queryFindByIdEmployee(@PathVariable("id") int id) {
//        System.out.println("ORMController queryFindByIdEmployee is called");
//        Person Person = ormService.findEmployeeById(id);
//        return new ModelAndView("/index", "resultObject", Person);
//    }
}
