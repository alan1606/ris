package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permiso")

public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permiso;

    @OneToMany(mappedBy = "permiso")
    private List<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuario;

    @OneToMany(mappedBy = "permiso")
    private List<PermisoUsuario> permisoUsuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public List<PlantillaPermisosTipoUsuario> getPlantillaPermisosTipoUsuario() {
        return plantillaPermisosTipoUsuario;
    }

    public void setPlantillaPermisosTipoUsuario(List<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuario) {
        this.plantillaPermisosTipoUsuario = plantillaPermisosTipoUsuario;
    }

    public List<PermisoUsuario> getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(List<PermisoUsuario> permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }
}
