package com.test.sber.service;

import com.test.sber.models.Company;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный интерфейс для работы с компаниями.
 */
public interface CompanyService {
    /**
     * Сохраняет компанию в базе данных.
     *
     * @param company Компания для сохранения.
     * @return Опциональный объект, содержащий сохраненную компанию.
     */
    Optional<Company> saveCompany(Company company);

    /**
     * Обновляет информацию о компании по ее ID.
     *
     * @param company   Новая информация о компании.
     * @param companyId ID компании для обновления.
     * @return Опциональный объект, содержащий обновленную компанию.
     */
    Optional<Company> updateCompany(Company company, Long companyId);

    /**
     * Получает список всех компаний.
     *
     * @return Опциональный объект, содержащий список всех компаний.
     */
    Optional<List<Company>> getAllCompanies();

    /**
     * Получает компанию по ее ID.
     *
     * @param companyId ID компании.
     * @return Опциональный объект, содержащий информацию о компании.
     */
    Optional<Company> getCompanyById(Long companyId);

    /**
     * Удаляет компанию по ее ID.
     *
     * @param companyId ID компании для удаления.
     */
    void removeCompany(Long companyId);
}
