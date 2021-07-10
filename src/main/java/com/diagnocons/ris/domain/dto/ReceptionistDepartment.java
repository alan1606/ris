package com.diagnocons.ris.domain.dto;

public class ReceptionistDepartment {
    private Long idReceptionistDepartment;
    private Long idReceptionist;
    private Long idDepartment;
    private boolean active;

    public Long getIdReceptionistDepartment() {
        return idReceptionistDepartment;
    }

    public void setIdReceptionistDepartment(Long idReceptionistDepartment) {
        this.idReceptionistDepartment = idReceptionistDepartment;
    }

    public Long getIdReceptionist() {
        return idReceptionist;
    }

    public void setIdReceptionist(Long idReceptionist) {
        this.idReceptionist = idReceptionist;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
