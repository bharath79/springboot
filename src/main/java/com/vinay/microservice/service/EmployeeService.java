package com.vinay.microservice.service;

import com.vinay.microservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String email);
}
