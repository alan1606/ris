package com.diagnocons.ris.domain.dto;

public class UserTypePermissionTemplate {
    private Long id;
    private Long idUserType;
    private Long idPermission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }
}
