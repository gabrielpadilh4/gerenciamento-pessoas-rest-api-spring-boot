package com.github.gabrielpadilh4.personapi.controller;

import com.github.gabrielpadilh4.personapi.dto.request.PersonDTO;
import com.github.gabrielpadilh4.personapi.dto.response.MessageResponseDTO;
import com.github.gabrielpadilh4.personapi.entity.Person;
import com.github.gabrielpadilh4.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

}
