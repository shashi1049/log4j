package com.log4j.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "test")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int emp_id;

    String emp_name;

    int emp_age;
}
