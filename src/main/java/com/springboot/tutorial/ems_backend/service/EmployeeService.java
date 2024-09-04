package com.springboot.tutorial.ems_backend.service;

import com.springboot.tutorial.ems_backend.dto.NewEmployeeDto;

import java.util.List;

public interface EmployeeService {
    NewEmployeeDto createEmployee(NewEmployeeDto newEmployeeDto);
    NewEmployeeDto getEmployeeById(Long employeeId);
    List<NewEmployeeDto> getAllEmployees();
    NewEmployeeDto updateEmployee(Long employeeId, NewEmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
