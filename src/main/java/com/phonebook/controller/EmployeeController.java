package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.slf4j.Logger;

@Controller
public class EmployeeController {

//    @Autowired
//    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);

    //    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
        logger.info("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeService.findAllEmployee();
        return new ModelAndView("/index", "resultObject", Employees);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchEmployee(@RequestParam("searchText") String text) {
        logger.info("EmployeeController searchEmployee is called");
        List<Employee> Employees = employeeService.searchEmployee(text);
        return new ModelAndView("/index", "resultObject", Employees);
    }

//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//    public ModelAndView test() {
//        logger.info("EmployeeController findAllEmployee is called");
//        List<Employee> Employees = employeeService.findAllEmployee();
//        return new ModelAndView("index", "resultObject", Employees);
//    }

    @RequestMapping("/view/{id}")
    public ModelAndView getEmployeeById(@PathVariable("id") long id) {
        Employee employee = this.employeeService.getEmployeeById(id);
        logger.info("EmployeeController getEmployeeById is called");
        return new ModelAndView("employee/view", "employee", employee);
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("employee") Employee employee){
//        if(employee.getId() == 0){
//            this.employeeService.addEmployee(employee);
//        }else {
//            this.employeeService.updateEmployee(employee);
//        }
        this.employeeService.addEmployee(employee);
        return "redirect:/index";
    }

//    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
//    public String addBook(@ModelAttribute("employee") Employee employee){
//        if(employee.getId() == 0){
//            this.employeeService.addEmployee(employee);
//        }else {
//            this.employeeService.updateEmployee(employee);
//        }
//        return "redirect:/index";
//    }
}
