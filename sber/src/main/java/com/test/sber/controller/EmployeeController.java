package com.test.sber.controller;

import com.test.sber.models.Employee;
import com.test.sber.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Контроллер для обработки запросов, связанных с сотрудниками компаний.
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Добавляет сотрудника к указанной компании.
     *
     * @param companyId ID компании, к которой будет добавлен сотрудник.
     * @param employee  Сотрудник для добавления.
     * @return Ответ с информацией о добавленном сотруднике.
     */
    @PostMapping("/company/{companyId}/employee")
    public ResponseEntity<Employee> addEmployeeToCompany(@PathVariable Long companyId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployeeFromCompany(employee, companyId).orElseThrow(NoSuchElementException::new));
    }

    /**
     * Обновляет информацию о сотруднике в указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника для обновления.
     * @param employee   Новая информация о сотруднике.
     * @return Ответ с обновленной информацией о сотруднике.
     */
    @PutMapping("/company/{companyId}/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeToCompany(@PathVariable Long companyId, @PathVariable Long employeeId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployeeToCompany(companyId, employeeId, employee).orElseThrow(NoSuchElementException::new));
    }

    /**
     * Получает список сотрудников для указанной компании.
     *
     * @param companyId ID компании.
     * @return Ответ с списком сотрудников компании.
     */
    @GetMapping("/company/{companyId}/employee")
    public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(employeeService.getEmployeesByCompanyId(companyId).orElseThrow(NoSuchElementException::new));
    }

    /**
     * Получает информацию о сотруднике в указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника.
     * @return Ответ с информацией о сотруднике.
     */
    @GetMapping("/company/{companyId}/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long companyId, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(companyId, employeeId).orElseThrow(NoSuchElementException::new));
    }

    /**
     * Удаляет сотрудника из указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника для удаления.
     * @return Ответ об успешном удалении сотрудника.
     */
    @DeleteMapping("/company/{companyId}/employee/{employeeId}")
    public ResponseEntity<Void> removeEmployeeInCompany(@PathVariable Long companyId, @PathVariable Long employeeId) {
        employeeService.removeEmployeeInCompany(companyId, employeeId);
        return ResponseEntity.noContent().build();
    }
}