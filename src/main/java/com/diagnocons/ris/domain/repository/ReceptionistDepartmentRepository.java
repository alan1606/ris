package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.ReceptionistDepartment;

import java.util.List;
import java.util.Optional;

public interface ReceptionistDepartmentRepository {
    Optional<List<ReceptionistDepartment>> getAll();
    Optional<ReceptionistDepartment> getById(Long id);
    Optional<List<ReceptionistDepartment>> getByIdReceptionist(Long idReceptionist);
    Optional<List<ReceptionistDepartment>> getByIdDeparment(Long idDepartment);
    Optional<ReceptionistDepartment> getByIdReceptionistsIdDepartment(Long idReceptionist, Long idDeparment);
    ReceptionistDepartment save (ReceptionistDepartment receptionistDepartment);
    boolean delete(Long id);
}
