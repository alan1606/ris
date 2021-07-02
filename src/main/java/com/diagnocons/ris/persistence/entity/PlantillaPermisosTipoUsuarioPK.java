package com.diagnocons.ris.persistence.entity;



import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PlantillaPermisosTipoUsuarioPK implements Serializable {
    private Long idTipoUsuario;
    private Long idPermiso;


    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }
}
