package com.test.sber.service.implement;

import com.test.sber.models.Company;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Реализация интерфейса CompanyService для работы с сущностью "Компания".
 * Обеспечивает методы для сохранения, обновления, получения информации о компаниях и их удаления.
 */
@Service
public class CompanyServiceImplement implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Сохраняет новую компанию в базе данных.
     *
     * @param company Компания для сохранения.
     * @return Опциональный объект, содержащий сохраненную компанию.
     * @throws IllegalArgumentException если компания с указанным ID уже существует.
     */
    @Override
    public Optional<Company> saveCompany(Company company) {
        if (companyRepository.findById(company.getId()).isPresent()) {
            throw new IllegalArgumentException("Company with ID " + company.getId() + " already exists.");
        }
        return Optional.of(companyRepository.save(company));
    }

    /**
     * Обновляет информацию о компании по ее ID.
     *
     * @param company   Новая информация о компании.
     * @param companyId ID компании для обновления.
     * @return Опциональный объект, содержащий обновленную компанию.
     * @throws NoSuchElementException если компания не найдена по указанному ID.
     */
    @Override
    public Optional<Company> updateCompany(Company company, Long companyId) {
        if (companyRepository.findById(company.getId()).isPresent()) {
            return Optional.of(companyRepository.save(company));
        } else {
            throw new NoSuchElementException("Company not found.");
        }
    }

    /**
     * Получает список всех компаний.
     *
     * @return Опциональный объект, содержащий список всех компаний.
     */
    @Override
    public Optional<List<Company>> getAllCompanies() {
        return Optional.of(companyRepository.findAll());
    }

    /**
     * Получает компанию по ее ID.
     *
     * @param companyId ID компании.
     * @return Опциональный объект, содержащий информацию о компании.
     * @throws NoSuchElementException если компания не найдена по указанному ID.
     */
    @Override
    public Optional<Company> getCompanyById(Long companyId) {
        return Optional.ofNullable(companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company with id " + companyId + " not found")));
    }

    /**
     * Удаляет компанию по ее ID.
     *
     * @param companyId ID компании для удаления.
     * @throws NoSuchElementException если компания не найдена по указанному ID.
     */

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
