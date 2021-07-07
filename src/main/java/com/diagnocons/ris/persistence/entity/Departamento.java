package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @OneToMany(mappedBy = "departamento")
    private List<Concepto> conceptoList;

    @OneToMany(mappedBy = "departamento")
    private List<LimiteEstudiosDiarios> limiteEstudiosDiariosList;

    @OneToMany(mappedBy = "departamento")
    private List<AgendaEnDepartamento> agendaEnDepartamentoList;

    @OneToMany(mappedBy = "departamento")
    private List<Cita> citaList;

    @OneToMany(mappedBy = "departamento")
    private List<RecepcionistaDepartamento> recepcionistaDepartamentoList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
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

    public List<Concepto> getConceptoList() {
        return conceptoList;
    }

    public void setConceptoList(List<Concepto> conceptoList) {
        this.conceptoList = conceptoList;
    }

    public List<LimiteEstudiosDiarios> getLimiteEstudiosDiariosList() {
        return limiteEstudiosDiariosList;
    }

    public void setLimiteEstudiosDiariosList(List<LimiteEstudiosDiarios> limiteEstudiosDiariosList) {
        this.limiteEstudiosDiariosList = limiteEstudiosDiariosList;
    }

    public List<AgendaEnDepartamento> getAgendaEnDepartamentoList() {
        return agendaEnDepartamentoList;
    }

    public void setAgendaEnDepartamentoList(List<AgendaEnDepartamento> agendaEnDepartamentoList) {
        this.agendaEnDepartamentoList = agendaEnDepartamentoList;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public List<RecepcionistaDepartamento> getRecepcionistaDepartamentoList() {
        return recepcionistaDepartamentoList;
    }

    public void setRecepcionistaDepartamentoList(List<RecepcionistaDepartamento> recepcionistaDepartamentoList) {
        this.recepcionistaDepartamentoList = recepcionistaDepartamentoList;
    }
}
