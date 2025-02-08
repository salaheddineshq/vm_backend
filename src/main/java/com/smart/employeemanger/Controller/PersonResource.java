package com.smart.employeemanger.Controller;

import com.smart.employeemanger.model.Employee;
import com.smart.employeemanger.model.Person;
import com.smart.employeemanger.service.EmployeeService;
import com.smart.employeemanger.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {
    private PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

        @GetMapping("/all")
        public ResponseEntity<List<Person>> getAllPersons () {
          List<Person> persons = personService.findAllPersons();
          return new ResponseEntity<>(persons, HttpStatus.OK);
        }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable("id") Long id) {
        Person person = personService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson (@RequestBody Person person) {
        Person newPerson= personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson (@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") Long id) {
        try {
            personService.deletePerson(id);
            return ResponseEntity.ok("Person with ID " + id + " was successfully deleted.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person with ID " + id + " not found.");
        }
    }


}
