package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.State;
import com.diagnocons.ris.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public Optional<List<State>> getAll(){
        return stateRepository.getAll();
    }

    public Optional<State> getById(Long id){
        return stateRepository.getById(id);
    }

    public Optional<State> getByName(String name){
        return stateRepository.getByName(name);
    }

    public Optional<State> getByByNomenclature(String nomenclature){
        return stateRepository.getByByNomenclature(nomenclature);
    }

    public State save(State state){
        return stateRepository.save(state);
    }

    public boolean delete(Long id){
        return stateRepository.delete(id);
    }
}
