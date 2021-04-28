package com.co.labo.docker.persistence;

import com.co.labo.docker.domain.dto.PersonDTO;
import com.co.labo.docker.persistence.entity.PersonEntity;
import com.co.labo.docker.persistence.mapper.PersonaMapper;
import com.co.labo.docker.persistence.repository.CrudPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonRepository {

    @Autowired
    CrudPerson crudPerson;

    public List<PersonDTO> getAllPersons() {
        List<PersonEntity> lsPerson = (List<PersonEntity>) crudPerson.findAll();
        return lsPerson.stream().map(PersonaMapper::convertirADominio).collect(Collectors.toList());
    }

    public PersonDTO deleteById(String id) {
        Optional<PersonEntity> personToDelete = crudPerson.findById(id);
        crudPerson.deleteById(id);
        return PersonaMapper.convertirADominio(personToDelete.get());
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        return PersonaMapper.convertirADominio(crudPerson.save(PersonaMapper.convertirAModelo(personDTO)));
    }

}
