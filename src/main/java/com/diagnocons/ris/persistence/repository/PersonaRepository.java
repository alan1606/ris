package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Person;
import com.diagnocons.ris.domain.repository.PersonRepository;
import com.diagnocons.ris.persistence.crud.PersonaCrudRepository;
import com.diagnocons.ris.persistence.entity.Persona;
import com.diagnocons.ris.persistence.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepository implements PersonRepository {

    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public Optional<List<Person>> getAll() {
       List<Persona> personas = (List<Persona>) personaCrudRepository.findAll();
       return Optional.of(mapper.toPersons(personas));
    }

    @Override
    public Optional<Person> getById(Long id) {
        return personaCrudRepository.findById(id).map(persona -> mapper.toPerson(persona));
    }

    @Override
    public Optional<Person> getByCurp(String curp) {
        return personaCrudRepository.findByCurp(curp).map(persona -> mapper.toPerson(persona));
    }

    @Override
    public Optional<Person> getByIdUser(Long idUser) {
        return personaCrudRepository.getByIdUsuario(idUser).map(persona -> mapper.toPerson(persona));
    }

    @Override
    public Optional<Person> getByBillingData(Long idBillingData) {
        return personaCrudRepository.findByIdDatosFacturacion(idBillingData).map(persona -> mapper.toPerson(persona));
    }

    @Override
    public Optional<Person> getByPatientId(String patientId) {
        return personaCrudRepository.findByPatientId(patientId).map(persona -> mapper.toPerson(persona));
    }

    @Override
    public Person save(Person person) {
        Persona persona = mapper.toPersona(person);
        return mapper.toPerson(personaCrudRepository.save(persona));
    }

    @Override
    public boolean delete(Long idPerson) {
        if(getById(idPerson).isPresent()){
            personaCrudRepository.deleteById(idPerson);
            return true;
        }
        return false;
    }
}
