package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.DepartmentService;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;

@Controller
public class EmployeeController {

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "departmentService")
    private DepartmentService departmentService;

//    public void setEmployeeService(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//    public void setDepartmentService(DepartmentService departmentService) {
//        this.departmentService = departmentService;
//    }

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);

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

    @RequestMapping("/view/{id}")
    public ModelAndView getEmployeeById(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        logger.info("EmployeeController getEmployeeById is called");
        return new ModelAndView("employee/view", "employee", employee);
    }

    @RequestMapping(value = "/edit/{id}", params = "form", method = RequestMethod.GET)
    public ModelAndView editForm(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeeById(id);

//        Map<String, Object> model = new HashMap<>();
//        model.put("employee", employeeService.getEmployeeById(id));
//        model.put("department", departmentService.getAllDepartments());

        logger.info("EmployeeController getEmployeeById is called");
        return new ModelAndView("employee/edit", "employee", employee);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }
}
