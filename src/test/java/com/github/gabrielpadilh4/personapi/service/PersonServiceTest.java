package com.github.gabrielpadilh4.personapi.service;

import com.github.gabrielpadilh4.personapi.dto.request.PersonDTO;
import com.github.gabrielpadilh4.personapi.dto.response.MessageResponseDTO;
import com.github.gabrielpadilh4.personapi.entity.Person;
import com.github.gabrielpadilh4.personapi.repository.PersonRepository;
import com.github.gabrielpadilh4.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.gabrielpadilh4.personapi.utils.PersonUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = CreateExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO CreateExpectedMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID " + id)
                .build();
    }

}
