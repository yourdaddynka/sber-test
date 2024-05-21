package com.test.sber.implement;

import com.test.sber.models.Company;
import com.test.sber.models.Employee;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.repository.EmployeeRepository;
import com.test.sber.service.implement.EmployeeServiceImplement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
//Необходимо добавить генерацию сущностей!
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplementTest {

    @InjectMocks
    private EmployeeServiceImplement employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    public void testSaveEmployeeFromCompany() {
        Employee employee = new Employee();
        Long companyId = 1L;
        Company company = new Company();
        company.setId(companyId);
        company.setEmployeeInCompany(new ArrayList<>());

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
        when(employeeRepository.save(employee)).thenReturn(employee);

        Optional<Employee> savedEmployee = employeeService.saveEmployeeFromCompany(employee, companyId);

        assertTrue(savedEmployee.isPresent());
        assertEquals(employee, savedEmployee.get());
    }

    @Test
    public void testSaveEmployeeFromCompanyNotFound() {
        Employee employee = new Employee();
        Long companyId = 1L;

        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> employeeService.saveEmployeeFromCompany(employee, companyId));
    }

}