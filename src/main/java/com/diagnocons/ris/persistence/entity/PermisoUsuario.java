package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "permisoUsuario")

public class PermisoUsuario {

    @EmbeddedId
    private PermisoUsuarioPK id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPermiso")
    private Permiso permiso;

}
