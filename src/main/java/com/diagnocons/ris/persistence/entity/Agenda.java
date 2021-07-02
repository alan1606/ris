package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dia;

    @OneToMany(mappedBy = "agenda")
    private List<Cita> citaList;

    @OneToMany(mappedBy = "agenda")
    private List<AgendaEnDepartamento> agendaEnDepartamentoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public List<AgendaEnDepartamento> getAgendaEnDepartamentoList() {
        return agendaEnDepartamentoList;
    }

    public void setAgendaEnDepartamentoList(List<AgendaEnDepartamento> agendaEnDepartamentoList) {
        this.agendaEnDepartamentoList = agendaEnDepartamentoList;
    }
}

