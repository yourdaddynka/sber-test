package com.test.sber.service;
import com.test.sber.models.Employee;
import com.test.sber.models.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(Long companyId, EmployeeDto employeeDto);
    EmployeeDto update(Long companyId, Long employeeID, EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeeForCompanyId(Long companyId);
    EmployeeDto getEmployeForId(Long companyId, Long commentId);
    void deleteEmployee(Long companyId, Long employeeId);
}
