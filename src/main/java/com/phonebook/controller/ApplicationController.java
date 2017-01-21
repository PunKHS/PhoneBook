package com.phonebook.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.phonebook.model.Employee;
import com.phonebook.model.Person;
import com.phonebook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.slf4j.Logger;

@Controller
public class ApplicationController {

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "departmentService")
    private DepartmentService departmentService;

    @Autowired(required = true)
    @Qualifier(value = "professionService")
    private ProfessionService professionService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    private PersonService personService;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationController.class);

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

    @JsonView(View.UI.class)
    @RequestMapping(value = "/search-person",  method = RequestMethod.GET)
    public @ResponseBody List<Person> getEmployeeForAutocomplete(@RequestParam("searchText") String text) {
        List<Person> persons = personService.searchPerson(text);
        return persons;
    }

    @RequestMapping("/view/{id}")
    public ModelAndView getEmployeeById(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        logger.info("EmployeeController getEmployeeById is called");
        return new ModelAndView("employee/employee_view", "employee", employee);
    }

    @RequestMapping(value = "/edit/{id}", params = "form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("department", departmentService.getAllDepartments());
        model.addAttribute("profession", professionService.getAllProfessions());
        model.addAttribute("person", personService.getAllPersons());
        return "employee/employee_edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView insert(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("person", personService.getAllPersons());
        model.addAttribute("department", departmentService.getAllDepartments());
        model.addAttribute("profession", professionService.getAllProfessions());
        return new ModelAndView("employee/employee_add", "employee", employee);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
}
