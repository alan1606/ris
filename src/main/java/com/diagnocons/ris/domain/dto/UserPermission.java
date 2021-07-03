package com.diagnocons.ris.domain.dto;

public class UserPermission {
    private Long id;
    private Long idUser;
    private Long idPermission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUserType) {
        this.idUser = idUserType;
    }

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

}
