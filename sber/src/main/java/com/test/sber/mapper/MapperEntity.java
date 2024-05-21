package com.test.sber.mapper;
import com.test.sber.models.Employee;
import com.test.sber.models.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class MapperEntity  implements Mapper<EmployeeDto, Employee>{
    @Override
    public Employee mapperEntity(EmployeeDto in) {
        Employee employee = new Employee();
        employee.setName(in.getName());
        employee.setLastName(in.getLastName());
        employee.setSalary(in.getSalary());
        employee.setRole(in.getRole());
        return employee;
    }
    @Override
    public EmployeeDto mapperDto(Employee out) {
        return EmployeeDto.builder()
                .name(out.getName())
                .lastName(out.getLastName())
                .salary(out.getSalary())
                .role(out.getRole())
                .build();
    }
}
