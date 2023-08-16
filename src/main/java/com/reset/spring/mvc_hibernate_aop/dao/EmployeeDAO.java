package com.reset.spring.mvc_hibernate_aop.dao;

import com.reset.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
