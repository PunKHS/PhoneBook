package com.phonebook.controller;

import com.phonebook.service.ORMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.phonebook.model.Employee;

import java.util.List;

@Controller
public class ORMController {
    
    @Autowired
    private ORMService ormService;

    @RequestMapping(value = "/ormFindAllEmployee", method = RequestMethod.GET)
    public ModelAndView ormFindAllEmployee() {
        System.out.println("ORMController ormFindAllEmployees is called");
        List<Employee> Employees = ormService.queryFindAllEmployee();
        return new ModelAndView("/orm/orm", "resultObject", Employees);
    }

    @RequestMapping(value = "/queryFindByIdEmployee/{id}", method = RequestMethod.GET)
    public ModelAndView queryFindByIdEmployee(@PathVariable("id") int id) {
        System.out.println("ORMController queryFindByIdEmployee is called");
        Employee Employee = ormService.queryFindEmployeeById(id);
        return new ModelAndView("/orm/orm", "resultObject", Employee);
    }
}
