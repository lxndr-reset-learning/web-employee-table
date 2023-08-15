package com.reset.spring.mvc_hibernate_aop.dao;

import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory; // Используем DI. Spring должен

    @Override
    @Transactional // аннотация сама открывает и закрывает транзакцию
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQueryResult = session.createQuery("from Employee ",
                Employee.class);

        return employeeQueryResult.getResultList();
    }
}
