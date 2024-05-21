package com.test.sber.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "company_name")
    String companyName;
    @Column(name = "employee_in_company")
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    List<Employee> employeeInCompany = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeInCompany.add(employee);
        employee.setCompany(this);
    }

    public void removeEmployee(Employee employee) {
        employeeInCompany.remove(employee);
        employee.setCompany(null);
    }


}
