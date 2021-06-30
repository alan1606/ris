package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "estudio")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idItem", insertable = false, updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "idPersona", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idTicket", insertable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "idTecnico", insertable = false, updatable = false)
    private Tecnico tecnico;

    @Column(name = "dicomId", length = 50)
    private String dicomId;

    private LocalDate fecha;

    private Boolean interpretado;

    private Boolean haSidoTomado;

    private Character prioridad;

    @Column(name = "clave", length = 50)
    private String clave;

    private BigDecimal precioVenta;

    @OneToMany(mappedBy = "estudio")
    private List<FotoEstudio> fotoEstudioList;

    @OneToMany(mappedBy = "estudio")
    private List<Dictamen> dictamenList;

    @OneToMany(mappedBy = "estudio")
    private List<Cita> citaList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getDicomId() {
        return dicomId;
    }

    public void setDicomId(String dicomId) {
        this.dicomId = dicomId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getInterpretado() {
        return interpretado;
    }

    public void setInterpretado(Boolean interpretado) {
        this.interpretado = interpretado;
    }

    public Boolean getHaSidoTomado() {
        return haSidoTomado;
    }

    public void setHaSidoTomado(Boolean haSidoTomado) {
        this.haSidoTomado = haSidoTomado;
    }

    public Character getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Character prioridad) {
        this.prioridad = prioridad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public List<FotoEstudio> getFotoEstudioList() {
        return fotoEstudioList;
    }

    public void setFotoEstudioList(List<FotoEstudio> fotoEstudioList) {
        this.fotoEstudioList = fotoEstudioList;
    }

    public List<Dictamen> getDictamenList() {
        return dictamenList;
    }

    public void setDictamenList(List<Dictamen> dictamenList) {
        this.dictamenList = dictamenList;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }
}
