package com.vinay.microservice.service;

import com.vinay.microservice.entity.EmployeeEntity;
import com.vinay.microservice.model.Employee;
import com.vinay.microservice.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null)
            employee.setId(UUID.randomUUID().toString());
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<Employee> employees = entities.stream()
                .map(entity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(entity, employee);
                    return employee;
                })
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity entity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(entity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with "+id+" is deleted";
    }
}
