package com.reset.spring.mvc_hibernate_aop.controller;

import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import com.reset.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    @RequestMapping("/showAllEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees); //Наш view будет использовать этот аттрибут, для того чтобы уже в нём выводить нужную информацию. По сути мы сейчас просто отформатировали нашлист под тот формат, который сможет использовать view
        Object allEmps = model.getAttribute("allEmps");

        if (allEmps != null) { //debug thing
            for (Employee emp : (List<Employee>) allEmps) {
                System.out.println(emp);
            }
        }

        return "all-employees-view";
    }
}
