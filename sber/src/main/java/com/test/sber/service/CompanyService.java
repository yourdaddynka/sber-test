package com.test.sber.service;
import com.test.sber.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<Company> saveCompany(Company company);
    Optional<Company> updateCompany(Company company,Long companyId);
    Optional<List<Company>> getAllCompanies();
    Optional<Company> getCompanyById(Long companyId);
    void removeCompany(Long companyId);
}
