package com.github.gabrielpadilh4.personapi.service;

import com.github.gabrielpadilh4.personapi.dto.request.PersonDTO;
import com.github.gabrielpadilh4.personapi.dto.response.MessageResponseDTO;
import com.github.gabrielpadilh4.personapi.entity.Person;
import com.github.gabrielpadilh4.personapi.exception.PersonNotFoundException;
import com.github.gabrielpadilh4.personapi.mapper.PersonMapper;
import com.github.gabrielpadilh4.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}
