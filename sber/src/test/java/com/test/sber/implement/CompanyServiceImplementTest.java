package com.test.sber.implement;

import com.test.sber.models.Company;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.service.implement.CompanyServiceImplement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplementTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImplement companyService;

    @Test
    void testSaveCompany() {
        // Arrange
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("Company Name");

        // Mocking behavior
        when(companyRepository.findById(company.getId())).thenReturn(Optional.empty());
        when(companyRepository.save(company)).thenReturn(company);

        // Act
        Optional<Company> savedCompany = companyService.saveCompany(company);

        // Assert
        assertEquals(company, savedCompany.orElse(null));
        verify(companyRepository, times(1)).findById(company.getId());
        verify(companyRepository, times(1)).save(company);
    }
}