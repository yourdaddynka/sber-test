package com.test.sber.controller;
import com.test.sber.models.Employee;
import com.test.sber.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

    @RestController
    @RequestMapping("/api")
    public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @PostMapping("/company/{companyId}/employee")
        public ResponseEntity<Employee> addEmployeeToCompany(@PathVariable Long companyId, @RequestBody Employee employee) {
            return ResponseEntity.ok(employeeService.saveEmployeeFromCompany(employee,companyId).orElseThrow(NoSuchElementException::new));
        }

        @PutMapping("/company/{companyId}/employee/{employeeId}")
        public ResponseEntity<Employee> updateEmployeeToCompany(@PathVariable Long companyId, @PathVariable Long employeeId, @RequestBody Employee employee) {
            return ResponseEntity.ok(employeeService.updateEmployeeToCompany(companyId,employeeId,employee).orElseThrow(NoSuchElementException::new));
        }

        @GetMapping("/company/{companyId}/employee")
        public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable Long companyId) {
            return ResponseEntity.ok(employeeService.getEmployeesByCompanyId(companyId).orElseThrow(NoSuchElementException::new));
        }

        @GetMapping("/company/{companyId}/employee/{employeeId}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long companyId, @PathVariable Long employeeId) {
            return ResponseEntity.ok(employeeService.getEmployeeById(companyId,employeeId).orElseThrow(NoSuchElementException::new));
        }

        @DeleteMapping("/company/{companyId}/employee/{employeeId}")
        public ResponseEntity<Void> removeEmployeeInCompany(@PathVariable Long companyId,@PathVariable Long employeeId) {
            employeeService.removeEmployeeInCompany(companyId,employeeId);
            return ResponseEntity.noContent().build();
        }
    }