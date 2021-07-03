package com.diagnocons.ris.domain.dto;

public class UserPhoto {
    private Long idUserPhoto;
    private Long idUser;
    private String path;

    public Long getIdUserPhoto() {
        return idUserPhoto;
    }

    public void setIdUserPhoto(Long idUserPhoto) {
        this.idUserPhoto = idUserPhoto;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
