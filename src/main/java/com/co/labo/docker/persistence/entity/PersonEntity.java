package com.co.labo.docker.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Person")
public class PersonEntity {
    @Id
    @Column(name = "IdentificationNumber", length = 20, nullable = false)
    private String identificationNumber;
    @Column(name = "Nombres", nullable = false)
    private String names;
    @Column(name = "Apellidos", nullable = false)
    private String surnames;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }
}
