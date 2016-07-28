package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.slf4j.Logger;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
        logger.info("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeServiceImpl.findAllEmployee();
        return new ModelAndView("index", "resultObject", Employees);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchEmployee(@RequestParam("searchText") String text) {
        logger.info("EmployeeController searchEmployee is called");
        List<Employee> Employees = employeeServiceImpl.searchEmployee(text);
        return new ModelAndView("index", "resultObject", Employees);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView test() {
        logger.info("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeServiceImpl.findAllEmployee();
        return new ModelAndView("index", "resultObject", Employees);
    }
}
