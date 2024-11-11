package com.example.SpringAngular.service;

import com.example.SpringAngular.dto.EmployeeDTO;
import com.example.SpringAngular.dto.EmployeeSaveDTO;
import com.example.SpringAngular.dto.EmployeeUpdateDTO;
import com.example.SpringAngular.dto.LoginDTO;
import com.example.SpringAngular.util.LoginResponse;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployee();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);

    LoginResponse loginEmployee(LoginDTO loginDTO);

    boolean isUsernameTaken(String username);
    
}
