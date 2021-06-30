package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "convenio")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idDatosFacturacion", insertable = false, updatable = false)
    private DatosFacturacion datosFacturacion;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @OneToMany(mappedBy = "convenio")
    private List<LimiteEstudiosDiarios> limiteEstudiosDiariosList;

    public Convenio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public DatosFacturacion getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(DatosFacturacion datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LimiteEstudiosDiarios> getLimiteEstudiosDiariosList() {
        return limiteEstudiosDiariosList;
    }

    public void setLimiteEstudiosDiariosList(List<LimiteEstudiosDiarios> limiteEstudiosDiariosList) {
        this.limiteEstudiosDiariosList = limiteEstudiosDiariosList;
    }
}
