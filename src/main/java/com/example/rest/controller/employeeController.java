package com.example.rest.controller;

import com.example.rest.Entity.Employee;
import com.example.rest.service.employeeService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeController {
    private employeeService employeeService;

    @Autowired
    public employeeController(com.example.rest.service.employeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }
    @GetMapping("/getEmployees")
    public List<Employee> readEmployee(){
        return employeeService.readEmployees();
    }
    @GetMapping("/getEmployees/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/getEmployees1/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeDetails(@PathVariable long id){
        return employeeService.DeleteEmployee(id);

    }
    @PutMapping("/update")
    public Employee updateEmployeeDetails(@RequestBody Employee employee){
        return employeeService.updateEmployeeDetails(employee);
    }
}
