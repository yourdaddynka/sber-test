package com.test.sber.service.implement;

import com.test.sber.models.Company;
import com.test.sber.models.Employee;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.repository.EmployeeRepository;
import com.test.sber.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Optional<Employee> saveEmployeeFromCompany(Employee employee, Long companyId) {
        return companyRepository.findById(companyId)
                .map(company -> {
                    if (company.getEmployeeInCompany().stream()
                            .noneMatch(e -> e.getId().equals(employee.getId()))) {
                        employee.setCompany(company);
                        company.addEmployee(employee);
                        return Optional.of(employeeRepository.save(employee));
                    } else {
                        throw new NoSuchElementException("Employee with id " + employee.getId() + " already exists in company with id " + companyId);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found"));
    }

    @Override
    public Optional<Employee> updateEmployeeToCompany(Long companyId, Long employeeId, Employee employee) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found"));
        Employee existingEmployee = company.getEmployeeInCompany().stream()
                .filter(e -> e.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Employee with id " + employeeId + " not found in company with id " + companyId));
        existingEmployee.setName(employee.getName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        return Optional.of(employeeRepository.save(existingEmployee));
    }

    @Override
    public Optional<List<Employee>> getEmployeesByCompanyId(Long companyId) {
        Optional<Company> company = Optional.ofNullable(companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found")));
        return Optional.ofNullable(company.get().getEmployeeInCompany());
    }

    @Override
    public Optional<Employee> getEmployeeById(Long companyId, Long employeeId) {
        return companyRepository.findById(companyId)
                .map(company -> company.getEmployeeInCompany().stream()
                        .filter(employee -> employee.getId().equals(employeeId))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("Employee with id " + employeeId + " not found in company with id " + companyId)));
    }

    @Override
    public void removeEmployeeInCompany(Long companyId, Long employeeId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found"));
        Employee employee = company.getEmployeeInCompany().stream()
                .filter(e -> e.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Employee with id " + employeeId + " not found in company with id " + companyId));
        company.removeEmployee(employee);
        employee.setCompany(null);
        employeeRepository.delete(employee);
    }

}

