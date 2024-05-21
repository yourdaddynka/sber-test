package com.test.sber.models.dto;

import com.test.sber.models.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmployeeDto {
    private String name;
    private String lastName;
    private Double salary;
    private Role role;
    private String companyName;
}
