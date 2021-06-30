package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "permiso_usuario")

public class PermisoUsuario {

    @EmbeddedId
    private PermisoUsuarioPK id;

    /*@ManyToOne
    @JoinColumn(name = "id_usuario", insertable=false, updatable = false)
    private Usuario usuario;*/

   /* @ManyToOne
    @JoinColumn(name = "id_permiso", insertable=false, updatable = false)
    private Permiso permiso;*/

    public PermisoUsuarioPK getId() {
        return id;
    }

    public void setId(PermisoUsuarioPK id) {
        this.id = id;
    }

   /* public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

   /* public Permiso getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(Permiso permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }*/
}
