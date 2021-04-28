package com.co.labo.docker.persistence.mapper;

import com.co.labo.docker.domain.dto.PersonDTO;
import com.co.labo.docker.persistence.entity.PersonEntity;

public class PersonaMapper {

    public static PersonDTO convertirADominio(PersonEntity personEntity){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setIdentificationNumber(personEntity.getIdentificationNumber());
        personDTO.setNames(personEntity.getNames());
        personDTO.setSurnames(personEntity.getSurnames());
        return personDTO;
    }

    public static PersonEntity convertirAModelo(PersonDTO personDTO){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setIdentificationNumber(personDTO.getIdentificationNumber());
        personEntity.setNames(personDTO.getNames());
        personEntity.setSurnames(personDTO.getSurnames());
        return personEntity;
    }
}
