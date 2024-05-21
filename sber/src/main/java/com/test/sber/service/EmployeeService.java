package com.test.sber.service;
import com.test.sber.models.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> saveEmployeeFromCompany(Employee employee, Long companyId);

    Optional<Employee> updateEmployeeToCompany(Long companyId, Long employeeId, Employee employee);

    Optional<List<Employee>> getEmployeesByCompanyId(Long companyId);

    Optional<Employee> getEmployeeById(Long companyId, Long employeeId);

    void removeEmployeeInCompany(Long companyId, Long employeeId);
}
