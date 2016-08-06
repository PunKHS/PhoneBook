package com.phonebook.controller;

import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    private EmployeeService employeeService;

    private MessageSource messageSource;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

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
        logger.info("EmployeeController getEmployeeById is called");
        return new ModelAndView("employee/edit", "employee", employee);
    }

//    @RequestMapping(value = "/edit2/{id}",params = "xxx", method = RequestMethod.POST)
//    public String update(Employee employee, BindingResult bindingResult, Model model) {
//        logger.info("Updating employee...");
//        if (bindingResult.hasErrors()) {
////            model.addAttribute("message", new Message("error",
////                    messageSource.getMessage("employee.saveFail", new Object[]{}, locale)));
//            model.addAttribute("employee", employee);
//            return "employee/edit";
//        }
//        logger.info(employee.getPerson().getName());
//        model.asMap().clear();
////        redirectAttributes.addFlashAttribute("message", new Message("success",
////                messageSource.getMessage("employee.saveSuccess", new Object[]{}, locale)));
//        employeeService.updateEmployee(employee);
////        return "redirect:/view/" + employee.getId();
//        return "redirect:/index";
//    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }
}
