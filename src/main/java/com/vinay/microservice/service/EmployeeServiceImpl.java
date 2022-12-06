package com.vinay.microservice.service;

import com.vinay.microservice.exception.EmployeeNotFoundException;
import com.vinay.microservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public final class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> al = new ArrayList<>();

    public Employee save(Employee employee) {
        if (employee.getId() == null)
            employee.setId(UUID.randomUUID().toString());
        al.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return al;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return al.stream().filter(e -> e.getEmailId().equals(id)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with email " + id + " not found"));
    }

    @Override
    public String deleteEmployeeById(String email) {
       Employee employee = al.stream().filter(e -> e.getEmailId().equals(email)).findFirst().get();
       al.remove(employee);
        return "Employee the email "+email+" is successfully deleted";
    }
}
