package com.example.SpringAngular.service.Impl;

import com.example.SpringAngular.dto.EmployeeDTO;
import com.example.SpringAngular.dto.EmployeeSaveDTO;
import com.example.SpringAngular.dto.EmployeeUpdateDTO;
import com.example.SpringAngular.dto.LoginDTO;
import com.example.SpringAngular.entity.Employee;
import com.example.SpringAngular.repo.EmployeeRepo;
import com.example.SpringAngular.service.EmployeeService;
import com.example.SpringAngular.util.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {

        Employee employee = new Employee();
        employee.setName(employeeSaveDTO.getName());
        employee.setEmail(employeeSaveDTO.getEmail());
        employee.setPhone(employeeSaveDTO.getPhone());
        employee.setUsername(employeeSaveDTO.getUsername());
        employee.setPassword(employeeSaveDTO.getPassword());

        employeeRepo.save(employee);
        return employee.getName();

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<Employee> getEmployees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee e : getEmployees) {

            EmployeeDTO employeeDTO = new EmployeeDTO(

                    e.getId(),
                    e.getName(),
                    e.getEmail(),
                    e.getPhone(),
                    e.getUsername(),
                    e.getPassword()
            );


            employeeDTOList.add(employeeDTO);
        }
        ;

        return employeeDTOList;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {

        if (employeeRepo.existsById(employeeUpdateDTO.getId())) {
            Employee employee = employeeRepo.getById(employeeUpdateDTO.getId());
            employee.setName(employeeUpdateDTO.getName());
            employee.setEmail(employeeUpdateDTO.getEmail());
            employee.setPhone(employeeUpdateDTO.getPhone());
            employee.setUsername(employeeUpdateDTO.getUsername());
            employee.setPassword(employeeUpdateDTO.getPassword());

            employeeRepo.save(employee);

        } else {
            System.out.println("Employee Id not Found");
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {

            System.out.println("Employee Id not Found");
        }

        return true;
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByUsername(loginDTO.getUsername());

        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String storedPassword = employee1.getPassword();

            if (password.equals(storedPassword)) {
                Optional<Employee> employee = employeeRepo.findOneByUsernameAndPassword(loginDTO.getUsername(),storedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Incorrect Password", false);
            }
        } else {
            return new LoginResponse("Username not found", false);
        }


    }

    @Override
    public boolean isUsernameTaken(String username) {
        Employee existingEmployee = employeeRepo.findByUsername(username);
        return existingEmployee != null;
    }

}