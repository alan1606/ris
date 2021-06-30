package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "fotoEstudio")
public class FotoEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEstudio", insertable = false, updatable = false)
    private Estudio estudio;

    @Column(name = "ruta", length = 40)
    private String ruta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
