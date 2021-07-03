package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.Receptionist;
import com.diagnocons.ris.domain.repository.ReceptionistRepository;
import com.diagnocons.ris.persistence.crud.RecepcionistaCrudRepository;
import com.diagnocons.ris.persistence.entity.Recepcionista;
import com.diagnocons.ris.persistence.mapper.ReceptionistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecepcionistaRepository implements ReceptionistRepository {
    @Autowired
    private RecepcionistaCrudRepository recepcionistaCrudRepository;

    @Autowired
    private ReceptionistMapper mapper;

    @Override
    public Optional<List<Receptionist>> getAll() {
        List<Recepcionista> recepcionistas = (List<Recepcionista>) recepcionistaCrudRepository.findAll();
        return Optional.of(mapper.toRecepcionists(recepcionistas));
    }

    @Override
    public Optional<Receptionist> getById(Long id) {
        return recepcionistaCrudRepository.findById(id).map(rec -> mapper.toRecepcionist(rec));
    }

    @Override
    public Optional<Receptionist> getByIdUser(Long idUser) {
        return recepcionistaCrudRepository.findByIdUsuario(idUser).map(rec -> mapper.toRecepcionist(rec));
    }

    @Override
    public Receptionist save(Receptionist receptionist) {
        Recepcionista recepcionista = mapper.toRecepcionista(receptionist);
        return mapper.toRecepcionist(recepcionistaCrudRepository.save(recepcionista));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            recepcionistaCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
