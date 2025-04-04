package com.smart.vm_avoca.service;


import com.smart.vm_avoca.exception.UserNotFoundException;
import com.smart.vm_avoca.model.Person;
import com.smart.vm_avoca.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person){
        person.setPersonCode(UUID.randomUUID().toString());
        return personRepo.save(person);
    }
    public List<Person> findAllPersons(){
        return personRepo.findAll();
    }

    public Person updatePerson(Person person){
        return personRepo.save(person);
    }

    public Person findPersonById(Long id){
        return personRepo.findPersonById(id)
                .orElseThrow(() -> new UserNotFoundException("User id" + id + "was not found "));
    }
    @Transactional
    public void deletePerson(Long id){
        personRepo.deletePersonById(id);
    }
}
