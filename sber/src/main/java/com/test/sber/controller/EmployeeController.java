package com.test.sber.controller;
import com.test.sber.models.dto.EmployeeDto;
import com.test.sber.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/company/{entityId}/employee")
    public ResponseEntity<EmployeeDto> create(@PathVariable Long entityId, @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(service.save(entityId,employeeDto), HttpStatus.CREATED);
    }
    @PutMapping("/company/{entityId}/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long entityId, @PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeUpdated = service.update(entityId, id, employeeDto);
        return new ResponseEntity<>(employeeUpdated, HttpStatus.OK);
    }
    @GetMapping("/company/{companyId}/employee")
    public List<EmployeeDto> listEmployeeForCompanyId(@PathVariable Long companyId) {
        return service.getEmployeeForCompanyId(companyId);
    }
    @GetMapping("/company/{companyId}/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeForId(@PathVariable Long companyId, @PathVariable Long id) {
        EmployeeDto employee = service.getEmployeForId(companyId,id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/company/{companyId}/employee{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long companyId, @PathVariable Long id) {
        service.deleteEmployee(companyId, id);
        return new ResponseEntity<>("Comment Deleted with exit !!", HttpStatus.OK);
    }

}
