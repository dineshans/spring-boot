package com.app.controller;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees")
public class EmpController {

    @Autowired
    private EmployeeRepository empRepository;


    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<String> hello() {

        return ResponseEntity.status(HttpStatus.OK).body("Hello Rest Controller");
    }

    @GetMapping(value = "/empDetails", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmpDetails() {

        List<Employee> employeeList = empRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @PostMapping(value = "/createEmployees", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        empRepository.save(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);

    }

    @PutMapping(value = "/updateEmployee", produces = "application/json")
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id, @RequestBody Employee employeeToUpdate) {

        Optional<Employee> optionalEmployee = empRepository.findById(id);

        optionalEmployee.ifPresent(employee -> {

            employee.setName(employeeToUpdate.getName());
            employee.setRole(employeeToUpdate.getRole());
            empRepository.save(employee);
        });
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


    }

    @DeleteMapping(value = "/deleteEmployees", produces = "application/json")
    public ResponseEntity<Void> deleteEmployee() {

        empRepository.deleteAll();

        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
