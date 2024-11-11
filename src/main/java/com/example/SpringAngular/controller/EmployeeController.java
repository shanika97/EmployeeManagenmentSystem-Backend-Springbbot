package com.example.SpringAngular.controller;

import com.example.SpringAngular.dto.EmployeeDTO;
import com.example.SpringAngular.dto.EmployeeSaveDTO;
import com.example.SpringAngular.dto.EmployeeUpdateDTO;
import com.example.SpringAngular.dto.LoginDTO;
import com.example.SpringAngular.service.EmployeeService;

import com.example.SpringAngular.util.LoginResponse;
import com.example.SpringAngular.util.StandarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/employee")


public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandarResponse> saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO) {
        String savedEmployeeId = employeeService.addEmployee(employeeSaveDTO);
//        String responseMessage = "Employee saved successfully with ID: " + savedEmployeeId;
//        return ResponseEntity.ok(responseMessage);
        return new ResponseEntity<>(
                new StandarResponse(200, "Success", ""),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse =employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/getAllEmployee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @PutMapping (path = "/update")
    public ResponseEntity<StandarResponse> updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        String savedEmployeeId = employeeService.updateEmployee(employeeUpdateDTO);
        return new ResponseEntity<>(
                new StandarResponse(200, "Success", ""),
                HttpStatus.OK
        );
    }


    @DeleteMapping  (path = "/delete/{id}")
    public ResponseEntity<StandarResponse> deleteEmployee(@PathVariable(value ="id")int id) {
        boolean deleteEmployee =employeeService.deleteEmployee(id);

        return new ResponseEntity<>(
                new StandarResponse(200, " Delete Successed", ""),
                HttpStatus.OK
        );
    }


    @GetMapping(path = "/isUsernameTaken/{username}")
    public ResponseEntity<Boolean> isUsernameTaken(@PathVariable(value = "username") String username) {
        boolean isTaken = employeeService.isUsernameTaken(username);
        return new ResponseEntity<>(isTaken, HttpStatus.OK);
    }


}
