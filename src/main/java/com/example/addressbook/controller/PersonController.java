package com.example.addressbook.controller;

import com.example.addressbook.model.Person;
import com.example.addressbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping()
    public List<Person> getAllPeople(@RequestParam(value = "start", defaultValue = "0")String start_id, @RequestParam(value = "limit", defaultValue = "3") String limit ) {
        return personService.getAllPeople(Integer.valueOf(start_id), Integer.valueOf(limit));
    }

    // Retrieves all entries with no limit, testing purposes only
    /* @GetMapping()
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    } */

    @GetMapping("/search")
    public List<Person> searchPeople(@RequestParam(value = "q")String nameField) {
        return personService.searchPeople(nameField);
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
