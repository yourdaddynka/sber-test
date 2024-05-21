//package com.test.sber.controller;
//
//import com.test.sber.models.Company;
//import com.test.sber.models.dto.CompanyDto;
//import com.test.sber.service.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////@RestController
////@RequestMapping("api/v1/apps")
////public class CompanyController {
////
////    @Autowired
////    private CompanyService companyService;
////
////    @GetMapping("/")
////    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
////        List<CompanyDto> companies = companyService.findAll();
////        return ResponseEntity.ok(companies);
////    }
////    @GetMapping("/companies")
////    public List<Company> getAllCompanies() {return companyService.findAll();}
////
////    @PostMapping("companies/save")
////    public Company createCompany(@RequestBody Company company) {return companyService.save(company).orElseThrow(() -> new UnsupportedOperationException(""));}
////
////    @GetMapping("companies/save/{id}")
////    public Company getCompanyById(@PathVariable Long id) {return companyService.findById(id).get();}
////
////    @PutMapping("companies/update")
////    public Company updateCompany(@RequestBody Company company) {return companyService.update(company).orElse(null);}
////
////    @DeleteMapping("companies/delete/{id}")
////    public void deleteCompany(@PathVariable Long id) {companyService.removeById(id);}
////}
//@RestController
//@RequestMapping("api/v1/companies")
//public class CompanyController {
//
//    @Autowired
//    private CompanyService companyService;
//
//}
