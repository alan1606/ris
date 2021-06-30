package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;


    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;


   /* @OneToMany(mappedBy = "tipoUsuario")
    private List<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuarios;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /*public List<PlantillaPermisosTipoUsuario> getPlantillaPermisosTipoUsuarios() {
        return plantillaPermisosTipoUsuarios;
    }

    public void setPlantillaPermisosTipoUsuarios(List<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuarios) {
        this.plantillaPermisosTipoUsuarios = plantillaPermisosTipoUsuarios;
    }*/
}
