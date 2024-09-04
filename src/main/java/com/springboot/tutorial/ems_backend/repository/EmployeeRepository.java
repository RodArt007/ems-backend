package com.springboot.tutorial.ems_backend.repository;

import com.springboot.tutorial.ems_backend.entity.NewEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<NewEmployee, Long> {
}
