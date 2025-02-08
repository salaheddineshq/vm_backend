package com.smart.employeemanger.model;

import com.smart.employeemanger.model.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID", nullable = false)
    private Person person;
    private String department;
    private String jobTitle;
    private Double salary;
    @Column(nullable = false, updatable = false)
    private String employeeCode;


}
