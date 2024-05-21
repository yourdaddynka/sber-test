package com.test.sber.service;

import com.test.sber.models.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный интерфейс для работы с сотрудниками компаний.
 */
public interface EmployeeService {
    /**
     * Сохраняет сотрудника для указанной компании.
     *
     * @param employee  Сотрудник для сохранения.
     * @param companyId ID компании, к которой будет привязан сотрудник.
     * @return Опциональный объект, содержащий сохраненного сотрудника.
     */
    Optional<Employee> saveEmployeeFromCompany(Employee employee, Long companyId);

    /**
     * Обновляет информацию о сотруднике в указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника для обновления.
     * @param employee   Новая информация о сотруднике.
     * @return Опциональный объект, содержащий обновленного сотрудника.
     */
    Optional<Employee> updateEmployeeToCompany(Long companyId, Long employeeId, Employee employee);

    /**
     * Получает список сотрудников для указанной компании.
     *
     * @param companyId ID компании.
     * @return Опциональный объект, содержащий список сотрудников компании.
     */
    Optional<List<Employee>> getEmployeesByCompanyId(Long companyId);

    /**
     * Получает информацию о сотруднике в указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника.
     * @return Опциональный объект, содержащий информацию о сотруднике.
     */
    Optional<Employee> getEmployeeById(Long companyId, Long employeeId);

    /**
     * Удаляет сотрудника из указанной компании.
     *
     * @param companyId  ID компании.
     * @param employeeId ID сотрудника для удаления.
     */
    void removeEmployeeInCompany(Long companyId, Long employeeId);
}
