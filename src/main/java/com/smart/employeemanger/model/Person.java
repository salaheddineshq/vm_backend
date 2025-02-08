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
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    private String cin;
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private String pictureUrl;
    @Column(nullable = false, updatable = false)
    private String personCode;
}
