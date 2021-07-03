package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;


@Entity
@Table(name = "permiso_usuario")

public class PermisoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_permiso")
    private Long idPermiso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
