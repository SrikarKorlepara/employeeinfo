package com.test.employeeinfo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone")
    private String phone;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) // unable to use fetch = FetchType.LAZY. need to find out why
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "position")
    private String position;
    @Column(name = "date_of_joining")
    private Date dateOfJoining;
    @Column(name = "status")
    private String status;

}

