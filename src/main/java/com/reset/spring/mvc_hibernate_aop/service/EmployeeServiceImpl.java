package com.reset.spring.mvc_hibernate_aop.service;

import com.reset.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EmployeeServiceImpl is a class that implements the EmployeeService interface.
 * It serves as a bridge between the EmployeeDAO (Data Access Object) and the Controller.
 * The class is annotated with @Service to indicate that it is a service component.
 * It is also annotated with @Transactional to automatically manage the transaction.
 */
@Service
@Transactional // аннотация сама открывает и закрывает транзакцию
public class EmployeeServiceImpl implements EmployeeService { //Прокладка между DAO и Controller

    @Autowired
    private EmployeeDAO employeeDAO; // Подключаем DAO (Data Access Object) с которым будем или не будем работать

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}
