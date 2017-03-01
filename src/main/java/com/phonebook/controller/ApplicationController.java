package com.phonebook.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.phonebook.model.Employee;
import com.phonebook.model.Person;
import com.phonebook.model.User;
import com.phonebook.service.*;
import com.phonebook.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView findAllEmployee() {
        logger.info("EmployeeController findAllEmployee is called");
        List<Employee> Employees = employeeService.findAllEmployee();
        return new ModelAndView("/welcome", "resultObject", Employees);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchEmployee(@RequestParam("searchText") String text) {
        logger.info("EmployeeController searchEmployee is called");
        List<Employee> Employees = employeeService.searchEmployee(text);
         return new ModelAndView("/welcome", "resultObject", Employees);
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

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
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
