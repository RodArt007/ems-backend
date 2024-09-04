package com.springboot.tutorial.ems_backend.mapper;

import com.springboot.tutorial.ems_backend.dto.NewEmployeeDto;
import com.springboot.tutorial.ems_backend.entity.NewEmployee;

public class NewEmployeeMapper {

    public static NewEmployeeDto mapToNewEmployeeDto(NewEmployee newEmployee) {
        return new NewEmployeeDto(
                newEmployee.getId(),
                newEmployee.getFirstName(),
                newEmployee.getLastName(),
                newEmployee.getEmail()
        );
    }

    public static NewEmployee mapToNewEmployee(NewEmployeeDto newEmployeeDto){
        return new NewEmployee(
                newEmployeeDto.getId(),
                newEmployeeDto.getFirstName(),
                newEmployeeDto.getLastName(),
                newEmployeeDto.getEmail()
        );
    }
}
