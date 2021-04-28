package com.co.labo.docker.persistence.repository;

import com.co.labo.docker.persistence.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPerson extends CrudRepository<PersonEntity,String> {
}
