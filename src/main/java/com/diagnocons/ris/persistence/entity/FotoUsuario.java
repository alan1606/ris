package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "fotoUsuario")
public class FotoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", updatable = false, insertable = false)
    private Usuario usuario;

    private String ruta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
