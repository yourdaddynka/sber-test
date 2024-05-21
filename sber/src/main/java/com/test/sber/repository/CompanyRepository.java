package com.test.sber.repository;

import com.test.sber.models.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends EntityRepository<Company, Long> {

}
