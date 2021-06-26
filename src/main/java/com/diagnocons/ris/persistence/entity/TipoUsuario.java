package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;


    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;


    @OneToMany(mappedBy = "tipoUsuario")
    private List<PlantillaPermisosTipoUsuario> plantillaPermisosTipoUsuarios;


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
}
