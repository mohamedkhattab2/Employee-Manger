package com.tec.employeemanager.repository;

import com.tec.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional findEmployeeById(Long id);
}
