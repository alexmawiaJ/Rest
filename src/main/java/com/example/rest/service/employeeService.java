package com.example.rest.service;

import com.example.rest.Entity.Employee;
import com.example.rest.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    private employeeRepository employeeRepository;

    @Autowired
    public employeeService(employeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }
    public Employee saveEmployee (Employee employee){
        return employeeRepository.save(employee);

    }
    public List<Employee> readEmployees(){

        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(long employee_ID_Number){
        return employeeRepository.findById(employee_ID_Number).orElse(null);
    }
    public Employee getEmployeeByName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }

    public String DeleteEmployee(long id){
         employeeRepository.deleteById(id);
         return "Employee Details Deleted " + id;
    }
    public Employee updateEmployeeDetails(Employee employee){
//        Employee existingEmployee = employeeRepository.getReferenceById(employee.getEmployee_ID_Number()).orElse);
        Employee existingEmployee = employeeRepository.findById(employee.getEmployee_ID_Number()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setSecondName(employee.getSecondName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setQualification(employee.getQualification());
        existingEmployee.setDateofBirth(employee.getDateofBirth());
        return employeeRepository.save(existingEmployee);

    }
}
