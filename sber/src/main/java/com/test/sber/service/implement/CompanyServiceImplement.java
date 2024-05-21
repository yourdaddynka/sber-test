package com.test.sber.service.implement;

import com.test.sber.mapper.CompanyInDtoToCompany;
import com.test.sber.models.Company;
import com.test.sber.repository.CompanyRepository;
import com.test.sber.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplement implements CompanyService {

    @Autowired
    private CompanyRepository repository;
    @Autowired
    private CompanyInDtoToCompany mapper;

    @Override
    public List<Company> findAll() {return repository.findAll();}
    @Override
    public Optional<Company> save(Company entity) {return Optional.of(repository.save(entity));}
    @Override
    public Optional<Company> findById(Long aLong) {return repository.findById(aLong);}
    @Override
    public Optional<Company> update(Company entity) {return Optional.of(repository.save(entity));}
    @Override
    public void removeById(Long aLong) {repository.deleteById(aLong);}


}
