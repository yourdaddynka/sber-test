package com.test.sber.repository;

import com.test.sber.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с сущностью Сотрудник.
 */
@Repository
public interface EmployeeRepository extends EntityRepository<Employee, Long> {

}
