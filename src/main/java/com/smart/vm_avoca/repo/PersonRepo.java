package com.smart.vm_avoca.repo;

import com.smart.vm_avoca.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Long> {


    void deletePersonById(Long id);

    Optional<Person> findPersonById(Long id);
}
