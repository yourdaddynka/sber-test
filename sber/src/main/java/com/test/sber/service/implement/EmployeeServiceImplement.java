package com.test.sber.service.implement;

import com.test.sber.mapper.MapperEntity;
import com.test.sber.models.Company;
import com.test.sber.models.Employee;
import com.test.sber.models.dto.EmployeeDto;
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
    MapperEntity mapper;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public EmployeeDto save(Long companyId, EmployeeDto employeeDto) {
        Employee employee = mapper.mapperEntity(employeeDto);
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId+ " not found"));
        employee.setCompany(company);
        Employee newComment = employeeRepository.save(employee);
        company.getEmployeeInCompany().add(newComment);
        return mapper.mapperDto(newComment);
    }

    @Override
    public EmployeeDto update(Long companyId, Long employeeID, EmployeeDto employeeDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId+ " not found"));
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new NoSuchElementException("Employee with id " + employeeID+ " not found"));
        if (!employee.getCompany().getId().equals(company.getId())) throw new NoSuchElementException( companyId + "Bad_Request" );
        employee.setRole(employeeDto.getRole());
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setSalary(employeeDto.getSalary());
        employee.setCompany(employeeDto.);
        Employee commentUpdate = employeeRepository.save(employee);
        return mapper.mapperDto(commentUpdate);

    }
    @Override
    public List<EmployeeDto> getEmployeeForCompanyId(Long companyId) {
        List<Employee> employees =  employeeRepository.getEmployeeForCompanyId(companyId);

    }

    @Override
    public EmployeeDto getEmployeForId(Long companyId, Long commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId+ " not found"));
        Employee employee = employeeRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("Employee with id " + commentId+ " not found"));
        if (!employee.getCompany().getId().equals(company.getId()))
            throw new NoSuchElementException( companyId + "Bad_Request" );
        return mapper.mapperDto(employee);
    }

    @Override
    public void deleteEmployee(Long companyId, Long employeeId) {
                Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company with id " + companyId+ " not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee with id " + companyId+ " not found"));
        if (!employee.getCompany().getId().equals(company.getId()))
            throw new NoSuchElementException(companyId+ "Bad_Request" );
        employeeRepository.delete(employee);
    }
}