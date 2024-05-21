package com.test.sber.implement;

import com.test.sber.models.Company;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.service.implement.CompanyServiceImplement;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//Необходимо добавить генерацию сущностей!
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplementTest {

    @InjectMocks
    private CompanyServiceImplement companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    public void testSaveCompany() {
        Company company = new Company();

        when(companyRepository.findById(company.getId())).thenReturn(Optional.empty());
        when(companyRepository.save(company)).thenReturn(company);

        Optional<Company> savedCompany = companyService.saveCompany(company);

        assertTrue(savedCompany.isPresent());
        assertEquals(company, savedCompany.get());
    }

    @Test
    public void testSaveCompanyAlreadyExists() {
        Company company = new Company();
        company.setId(1L);

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));

        assertThrows(IllegalArgumentException.class, () -> companyService.saveCompany(company));
    }

    @Test
    public void testUpdateCompany() {
        Company company = new Company();
        Long companyId = 1L;

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));
        when(companyRepository.save(company)).thenReturn(company);

        Optional<Company> updatedCompany = companyService.updateCompany(company, companyId);

        assertTrue(updatedCompany.isPresent());
        assertEquals(company, updatedCompany.get());
    }

    @Test
    public void testUpdateCompanyNotFound() {
        Company company = new Company();
        Long companyId = 1L;

        when(companyRepository.findById(company.getId())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> companyService.updateCompany(company, companyId));
    }

    @Test
    public void testGetAllCompanies() {
        List<Company> companies = new ArrayList<>();

        when(companyRepository.findAll()).thenReturn(companies);

        Optional<List<Company>> retrievedCompanies = companyService.getAllCompanies();

        assertTrue(retrievedCompanies.isPresent());
        assertEquals(companies, retrievedCompanies.get());
    }

    @Test
    public void testGetCompanyById() {
        Company company = new Company();
        Long companyId = 1L;

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));

        Optional<Company> retrievedCompany = companyService.getCompanyById(companyId);

        assertTrue(retrievedCompany.isPresent());
        assertEquals(company, retrievedCompany.get());
    }

    @Test
    public void testGetCompanyByIdNotFound() {
        Long companyId = 1L;

        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> companyService.getCompanyById(companyId));
    }

    @Test
    public void testRemoveCompany() {
        Long companyId = 1L;

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company()));
        doNothing().when(companyRepository).deleteById(companyId);

        assertDoesNotThrow(() -> companyService.removeCompany(companyId));
    }

    @Test
    public void testRemoveCompanyNotFound() {
        Long companyId = 1L;

        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> companyService.removeCompany(companyId));
    }
}