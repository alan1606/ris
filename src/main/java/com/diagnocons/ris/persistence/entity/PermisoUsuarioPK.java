package com.diagnocons.ris.persistence.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PermisoUsuarioPK implements Serializable {
    private Long idUsuario;
    private Long idPermiso;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }
}
