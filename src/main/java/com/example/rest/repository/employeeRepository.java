package com.example.rest.repository;

import com.example.rest.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository  extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String firstName);
}
