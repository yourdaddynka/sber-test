package com.test.sber.mapper;

import com.test.sber.models.Company;
import com.test.sber.models.dto.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyInDtoToCompany implements Mapper<CompanyDto, Company> {
    @Override
    public Company mapperEntity(CompanyDto in) {
        Company company = new Company();
        company.setCompanyName(in.getCompanyName());
        return company;
    }

    @Override
    public CompanyDto mapperDto(Company out) {
        return CompanyDto.builder()
                .companyName(out.getCompanyName())
                .build();
    }
}
