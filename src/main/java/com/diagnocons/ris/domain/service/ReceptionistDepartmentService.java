package com.diagnocons.ris.domain.service;

import com.diagnocons.ris.domain.dto.ReceptionistDepartment;
import com.diagnocons.ris.domain.repository.ReceptionistDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistDepartmentService {
    @Autowired
    private ReceptionistDepartmentRepository receptionistDepartmentRepository;

    public Optional<List<ReceptionistDepartment>> getAll(){
        return receptionistDepartmentRepository.getAll();
    }

    public Optional<ReceptionistDepartment> getById(Long id){
        return receptionistDepartmentRepository.getById(id);
    }

    public Optional<List<ReceptionistDepartment>> getByIdReceptionist(Long idReceptionist){
        return receptionistDepartmentRepository.getByIdReceptionist(idReceptionist);
    }

    public Optional<List<ReceptionistDepartment>> getByIdDeparment(Long idDepartment){
        return receptionistDepartmentRepository.getByIdDeparment(idDepartment);
    }

    public Optional<ReceptionistDepartment> getByIdReceptionistsIdDepartment(Long idReceptionist, Long idDeparment){
        return receptionistDepartmentRepository.getByIdReceptionistsIdDepartment(idReceptionist, idDeparment);
    }

    public ReceptionistDepartment save (ReceptionistDepartment receptionistDepartment){
        return receptionistDepartmentRepository.save(receptionistDepartment);
    }

    public boolean delete(Long id){
        return receptionistDepartmentRepository.delete(id);
    }
}
