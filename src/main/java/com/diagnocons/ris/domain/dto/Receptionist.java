package com.diagnocons.ris.domain.dto;

import java.time.LocalDate;

public class Receptionist {
    private Long idRecepcionist;
    private Long idUser;
    private String firstName;
    private String secondName;
    private String lastName;
    private String motherLastName;
    private char gender;
    private LocalDate birthDay;

    public Long getIdRecepcionist() {
        return idRecepcionist;
    }

    public void setIdRecepcionist(Long id) {
        this.idRecepcionist = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String moterLastName) {
        this.motherLastName = moterLastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
