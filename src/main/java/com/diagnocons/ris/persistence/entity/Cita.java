package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idAgenda", insertable = false, updatable = false)
    private Agenda agenda;

    @ManyToOne
    @JoinColumn(name = "idEstudio", insertable = false, updatable = false)
    private Estudio estudio;

    @ManyToOne
    @JoinColumn(name = "idRecepcionista", insertable = false, updatable = false)
    private Recepcionista recepcionista;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
    private Departamento departamento;

    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
