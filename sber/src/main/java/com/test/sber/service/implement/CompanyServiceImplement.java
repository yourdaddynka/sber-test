package com.test.sber.service.implement;

import com.test.sber.models.Company;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompanyServiceImplement implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> saveCompany(Company company) {
        if (companyRepository.findById(company.getId()).isPresent()) {
            throw new IllegalArgumentException("Company with ID " + company.getId() + " already exists.");
        }
        return Optional.of(companyRepository.save(company));
    }

    @Override
    public Optional<Company> updateCompany(Company company, Long companyId) {
        if (companyRepository.findById(company.getId()).isPresent()) {
            return Optional.of(companyRepository.save(company));
        } else {
            throw new NoSuchElementException("Company not found.");
        }
    }

    @Override
    public Optional<List<Company>> getAllCompanies() {
        return Optional.of(companyRepository.findAll());
    }

    @Override
    public Optional<Company> getCompanyById(Long companyId) {
        return Optional.ofNullable(companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found")));
    }

    @Override
    public void removeCompany(Long companyId) {
        companyRepository.findById(companyId)
                .ifPresentOrElse(
                        company -> companyRepository.deleteById(companyId),
                        () -> {
                            throw new NoSuchElementException("Company with id " + companyId + " not found, cannot remove.");
                        }
                );
    }

}
