package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Person;
import com.diagnocons.ris.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Optional<List<Person>> getAll(){
        return personRepository.getAll();
    }

    public Optional<Person> getById(Long id){
        return personRepository.getById(id);
    }

    public Optional<Person> getByCurp(String curp){
        return personRepository.getByCurp(curp);
    }

    public Optional<Person> getByIdUser(Long idUser){
        return personRepository.getByIdUser(idUser);
    }

    public Optional<Person> getByBillingData(Long idBillingData){
        return personRepository.getByBillingData(idBillingData);
    }

    public Optional<Person> getByPatientId(String patientId){
        return personRepository.getByPatientId(patientId);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public boolean delete(Long idPerson){
        return personRepository.delete(idPerson);
    }

}
