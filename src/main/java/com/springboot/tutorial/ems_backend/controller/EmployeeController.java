package com.springboot.tutorial.ems_backend.controller;

import com.springboot.tutorial.ems_backend.dto.NewEmployeeDto;
import com.springboot.tutorial.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<NewEmployeeDto> createEmployee(@RequestBody NewEmployeeDto newEmployeeDto){
        NewEmployeeDto savedEmployee = employeeService.createEmployee(newEmployeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewEmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        NewEmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<NewEmployeeDto>> getAllEmployees(){
        List<NewEmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewEmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                         @RequestBody NewEmployeeDto updatedEmployee){
        NewEmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(updatedEmployeeDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
