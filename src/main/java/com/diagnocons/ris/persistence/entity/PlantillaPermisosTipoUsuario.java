package com.diagnocons.ris.persistence.entity;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "plantilla_permisos_tipo_usuario")
public class PlantillaPermisosTipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    @Column(name = "id_permiso")
    private Long idPermiso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
