package com.test.sber.models.dto;

import com.test.sber.models.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyDto {
    private String companyName;
}
