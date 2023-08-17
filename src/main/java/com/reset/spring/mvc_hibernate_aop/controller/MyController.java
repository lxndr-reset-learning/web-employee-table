package com.reset.spring.mvc_hibernate_aop.controller;

import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import com.reset.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/showAllEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees); //Наш view будет использовать этот аттрибут, для того чтобы уже в нём выводить нужную информацию. По сути мы сейчас просто отформатировали нашлист под тот формат, который сможет использовать view
        Object allEmps = model.getAttribute("allEmps");

        return "all-employees-view";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) { //Получаем из view с формой аттрибут "employee", который мы уже создали в методе addNewEmployee
        employeeService.saveEmployee(employee);

        return "redirect:/showAllEmployees";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int employeeId, Model model) {
        model.addAttribute("employee",
                employeeService.getEmployeeById(employeeId));

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int employeeId) {
        employeeService.deleteEmployeeById(employeeId);

        return "redirect:/showAllEmployees";
    }
}
