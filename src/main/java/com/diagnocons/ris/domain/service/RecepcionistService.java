package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.Receptionist;
import com.diagnocons.ris.domain.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcionistService {
    @Autowired
    private ReceptionistRepository receptionistRepository;

    public Optional<List<Receptionist>> getAll(){
        return receptionistRepository.getAll();
    }

    public Optional<Receptionist> getById(Long id){
        return receptionistRepository.getById(id);
    }

    public Optional<Receptionist> getByIdUser(Long idUser){
        return receptionistRepository.getByIdUser(idUser);
    }

    public Receptionist save(Receptionist receptionist ){
        return receptionistRepository.save(receptionist);
    }

    public boolean delete (Long id){
        return receptionistRepository.delete(id);
    }
}
