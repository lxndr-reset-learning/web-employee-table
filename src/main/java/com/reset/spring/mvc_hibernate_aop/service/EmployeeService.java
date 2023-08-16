package com.reset.spring.mvc_hibernate_aop.service;

import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface EmployeeService {
    public List<Employee> getAllEmployees();
}
