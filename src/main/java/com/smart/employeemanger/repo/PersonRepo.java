package com.smart.employeemanger.repo;

import com.smart.employeemanger.model.Employee;
import com.smart.employeemanger.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Long> {


    void deletePersonById(Long id);

    Optional<Person> findPersonById(Long id);
}
