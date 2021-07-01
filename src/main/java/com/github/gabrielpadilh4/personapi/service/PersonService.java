package com.github.gabrielpadilh4.personapi.service;

import com.github.gabrielpadilh4.personapi.dto.MessageResponseDTO;
import com.github.gabrielpadilh4.personapi.entity.Person;
import com.github.gabrielpadilh4.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}
