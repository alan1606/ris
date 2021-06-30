package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "recepcionistaDepartamento")
public class RecepcionistaDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idRecepcionista", insertable = false, updatable = false)
    private Recepcionista recepcionista;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
    private Departamento departamento;

    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
