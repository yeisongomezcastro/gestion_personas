package com.co.labo.docker.domain.service;

import com.co.labo.docker.domain.dto.PersonDTO;
import com.co.labo.docker.persistence.PersonRepository;
import com.co.labo.docker.persistence.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> getAllContacts() {
        return personRepository.getAllPersons();
    }

    public PersonDTO deleteById(String id) {
        return personRepository.deleteById(id);
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        return personRepository.savePerson(personDTO);
    }

}
