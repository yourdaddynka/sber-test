package com.test.sber.models;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    Double salary;
    Role role;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
    Company company;
}
