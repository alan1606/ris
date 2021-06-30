package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plantillaPermisosTipoUsuario")
public class PlantillaPermisosTipoUsuario {
    @EmbeddedId
    private PlantillaPermisosTipoUsuarioPK id;

    @ManyToOne
    @JoinColumn(name = "idTipoUsuario", insertable=false, updatable = false)
    private TipoUsuario tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "idPermiso", insertable=false, updatable = false)
    private Permiso permiso;

    public PlantillaPermisosTipoUsuarioPK getId() {
        return id;
    }

    public void setId(PlantillaPermisosTipoUsuarioPK id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
}
