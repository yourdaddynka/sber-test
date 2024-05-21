package com.test.sber.controller;

import com.test.sber.models.Company;
import com.test.sber.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


/**
 * Контроллер для обработки запросов, связанных с компаниями.
 */
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    /**
     * Добавляет новую компанию.
     *
     * @param company Информация о компании для добавления.
     * @return Ответ с информацией о добавленной компании.
     */
    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.saveCompany(company).orElseThrow(NoSuchElementException::new));
    }
    /**
     * Обновляет информацию о компании по ее ID.
     *
     * @param company    Новая информация о компании.
     * @param companyId  ID компании для обновления.
     * @return Ответ с обновленной информацией о компании.
     */
    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.updateCompany(company, companyId).orElseThrow(NoSuchElementException::new));

    }
    /**
     * Получает список всех компаний.
     *
     * @return Ответ с списком всех компаний.
     */
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return ResponseEntity.ok(companyService.getAllCompanies().orElseThrow(NoSuchElementException::new));
    }
    /**
     * Получает информацию о компании по ее ID.
     *
     * @param companyId ID компании.
     * @return Ответ с информацией о компании.
     */
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyById(companyId).orElseThrow(NoSuchElementException::new));
    }
    /**
     * Удаляет компанию по ее ID.
     *
     * @param companyId ID компании для удаления.
     * @return Ответ об успешном удалении компании.
     */
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> removeCompany(@PathVariable Long companyId) {
        companyService.removeCompany(companyId);
        return ResponseEntity.noContent().build();

    }
}
