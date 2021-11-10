package com.tec.employeemanager.controller;

import com.tec.employeemanager.model.Employee;
import com.tec.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // constructor injector
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService ){
        this.employeeService= employeeService;
    }

    // get all employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // find an employee by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // add an employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // update an employee
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee updateEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    // delete an employee
    @DeleteMapping("/delete/{id)")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


















}
