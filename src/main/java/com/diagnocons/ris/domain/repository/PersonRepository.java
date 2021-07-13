package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Optional<List<Person>> getAll();
    Optional<Person> getById(Long id);
    Optional<Person> getByCurp(String curp);
    Optional<Person> getByIdUser(Long idUser);
    Optional<Person> getByBillingData(Long idBillingData);
    Optional<Person> getByPatientId(String patientId);
    Person save(Person person);
    boolean delete(Long idPerson);
}
