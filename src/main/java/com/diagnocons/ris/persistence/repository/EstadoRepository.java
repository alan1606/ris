package com.diagnocons.ris.persistence.repository;


import com.diagnocons.ris.domain.dto.State;
import com.diagnocons.ris.domain.repository.StateRepository;
import com.diagnocons.ris.persistence.crud.EstadoCrudRepository;
import com.diagnocons.ris.persistence.entity.Estado;
import com.diagnocons.ris.persistence.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstadoRepository implements StateRepository {
    @Autowired
    private EstadoCrudRepository estadoCrudRepository;

    @Autowired
    private StateMapper mapper;

    @Override
    public Optional<List<State>> getAll() {
        List<Estado> estados = (List<Estado>) estadoCrudRepository.findAll();
        return Optional.of(mapper.toStates(estados));
    }

    @Override
    public Optional<State> getById(Long id) {
        return estadoCrudRepository.findById(id).map(estado -> mapper.toState(estado));
    }

    @Override
    public Optional<State> getByName(String name) {
        return estadoCrudRepository.findByNombre(name).map(estado -> mapper.toState(estado));
    }

    @Override
    public Optional<State> getByByNomenclature(String nomenclature) {
        return estadoCrudRepository.findByAbreviatura(nomenclature).map(estado -> mapper.toState(estado));
    }

    @Override
    public State save(State state) {
        Estado estado = mapper.toEstado(state);
        return mapper.toState(estadoCrudRepository.save(estado));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            estadoCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
