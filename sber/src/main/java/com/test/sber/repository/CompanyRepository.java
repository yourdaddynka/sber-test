package com.test.sber.repository;

import com.test.sber.models.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Репозиторий для работы с сущностью Компания.
 */
@Repository
public interface CompanyRepository extends EntityRepository<Company, Long> {

}
