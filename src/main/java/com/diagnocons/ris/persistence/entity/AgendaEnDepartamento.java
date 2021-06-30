package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "agendaEnDepartamento")
public class AgendaEnDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idAgenda", insertable = false, updatable = false)
    private Agenda agenda;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
    private Departamento departamento;

    private LocalTime horaInicio;

    private LocalTime horaFin;

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
