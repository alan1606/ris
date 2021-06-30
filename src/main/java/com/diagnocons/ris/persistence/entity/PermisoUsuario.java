package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "permisoUsuario")

public class PermisoUsuario {

    @EmbeddedId
    private PermisoUsuarioPK id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable=false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPermiso", insertable=false, updatable = false)
    private Permiso permiso;

    public PermisoUsuarioPK getId() {
        return id;
    }

    public void setId(PermisoUsuarioPK id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
}
