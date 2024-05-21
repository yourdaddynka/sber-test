package com.test.sber.controller;
import com.test.sber.models.Company;
import com.test.sber.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.saveCompany(company).orElseThrow(NoSuchElementException::new));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.updateCompany(company,companyId).orElseThrow(NoSuchElementException::new));

    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return ResponseEntity.ok(companyService.getAllCompanies().orElseThrow(NoSuchElementException::new));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyById(companyId).orElseThrow(NoSuchElementException::new));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> removeCompany(@PathVariable Long companyId) {
        companyService.removeCompany(companyId);
        return ResponseEntity.noContent().build();

    }
}
