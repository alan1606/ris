package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.ReceptionistDepartment;
import com.diagnocons.ris.domain.repository.ReceptionistDepartmentRepository;
import com.diagnocons.ris.persistence.crud.RecepcionistaDepartamentoCrudRepository;
import com.diagnocons.ris.persistence.entity.RecepcionistaDepartamento;
import com.diagnocons.ris.persistence.mapper.ReceptionistDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecepcionistaDepartamentoRespository implements ReceptionistDepartmentRepository {

    @Autowired
    private RecepcionistaDepartamentoCrudRepository recepcionistaDepartamentoCrudRepository;

    @Autowired
    private ReceptionistDepartmentMapper mapper;

    @Override
    public Optional<List<ReceptionistDepartment>> getAll() {
        List<RecepcionistaDepartamento> recepcionistaDepartamentos = (List<RecepcionistaDepartamento>) recepcionistaDepartamentoCrudRepository.findAll();
        return Optional.of(mapper.toReceptionistsDepartments(recepcionistaDepartamentos));
    }

    @Override
    public Optional<ReceptionistDepartment> getById(Long id) {
        return recepcionistaDepartamentoCrudRepository.findById(id).map(recepcionistaDepartamento -> mapper.toRecepcionistDepartment(recepcionistaDepartamento));
    }

    @Override
    public Optional<List<ReceptionistDepartment>> getByIdReceptionist(Long idReceptionist) {
        List<RecepcionistaDepartamento> lista = recepcionistaDepartamentoCrudRepository.findByIdRecepcionsta(idReceptionist);
        return Optional.of(mapper.toReceptionistsDepartments(lista));
    }

    @Override
    public Optional<List<ReceptionistDepartment>> getByIdDeparment(Long idDepartment) {
        List<RecepcionistaDepartamento> lista = recepcionistaDepartamentoCrudRepository.findByIdDepartamento(idDepartment);
        return Optional.of(mapper.toReceptionistsDepartments(lista));
    }

    @Override
    public Optional<ReceptionistDepartment> getByIdReceptionistsIdDepartment(Long idReceptionist, Long idDeparment) {
        return recepcionistaDepartamentoCrudRepository.findByIdRecepcionstaIdDepartamento(idReceptionist, idDeparment).map(recepcionistaDepartamento -> mapper.toRecepcionistDepartment(recepcionistaDepartamento));
    }

    @Override
    public ReceptionistDepartment save(ReceptionistDepartment receptionistDepartment) {
        RecepcionistaDepartamento recepcionistaDepartamento = mapper.toRecepcionistaDepartamento(receptionistDepartment);
        return mapper.toRecepcionistDepartment(recepcionistaDepartamentoCrudRepository.save(recepcionistaDepartamento));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            recepcionistaDepartamentoCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
