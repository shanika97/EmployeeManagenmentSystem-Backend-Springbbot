package com.example.SpringAngular.repo;

import com.example.SpringAngular.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Optional<Employee> findOneByUsernameAndPassword(String username, String storedPassword);
    //check email
    Employee findByUsername(String username);

    

}