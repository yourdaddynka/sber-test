package com.test.sber.repository;

import com.test.sber.models.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends EntityRepository<Company, Long> {
}
