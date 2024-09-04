package com.springboot.tutorial.ems_backend.service;

import com.springboot.tutorial.ems_backend.dto.NewEmployeeDto;
import com.springboot.tutorial.ems_backend.entity.NewEmployee;
import com.springboot.tutorial.ems_backend.exception.ResourceNotFoundException;
import com.springboot.tutorial.ems_backend.mapper.NewEmployeeMapper;
import com.springboot.tutorial.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public NewEmployeeDto createEmployee(NewEmployeeDto newEmployeeDto) {

        NewEmployee newEmployee = NewEmployeeMapper.mapToNewEmployee(newEmployeeDto);
        return NewEmployeeMapper.
                mapToNewEmployeeDto(employeeRepository.save(newEmployee));
    }

    @Override
    public NewEmployeeDto getEmployeeById(Long employeeId) {
        NewEmployee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id given: " + employeeId));
        return NewEmployeeMapper.mapToNewEmployeeDto(employee) ;
    }

    @Override
    public List<NewEmployeeDto> getAllEmployees() {
        List<NewEmployee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)-> NewEmployeeMapper.mapToNewEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public NewEmployeeDto updateEmployee(Long employeeId, NewEmployeeDto updatedEmployee) {
        NewEmployee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id given: " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        return NewEmployeeMapper.mapToNewEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        NewEmployee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id given: " + employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
