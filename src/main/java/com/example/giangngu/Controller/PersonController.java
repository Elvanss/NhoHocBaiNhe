package com.example.giangngu.Controller;

import com.example.giangngu.Entity.Person;
import com.example.giangngu.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    // READ - Get all Persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAllPerson();
    }

    // READ - Get Person by ID
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        return personService.findPersonById(id);
    }

    // CREATE - Create a Person
    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return personService.createPerson(person);
    }

    // UPDATE - Update a Person
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Integer id, @Valid @RequestBody Person update) {
        return personService.update(id, update);
    }

    // DELETE - Delete a Person by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        personService.deleteById(id);
    }

    // DELETE - Delete all Persons
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        personService.deleteAll();
    }
}
