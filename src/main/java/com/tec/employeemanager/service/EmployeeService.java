package com.tec.employeemanager.service;

import com.tec.employeemanager.exception.UserNotFoundException;
import com.tec.employeemanager.model.Employee;
import com.tec.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    // add Employee
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    // find all employees
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    // Update an employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // find Employee by id
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + "was not found"));

    }

    // Delete an employee
   public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
   }








}
