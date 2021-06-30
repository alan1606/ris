package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idDatosFacturacion", insertable = false, updatable = false)
    private DatosFacturacion datosFacturacion;

    private LocalDate fecha;

    private LocalTime hora;

    private Boolean requiereFactura;

    private Character estado;

    private BigDecimal total;

    @OneToMany(mappedBy = "ticket")
    private List<FotoTicket> fotoTicket;

    @OneToMany(mappedBy = "ticket")
    private List<PagoTicket> pagoTicketList;

    @OneToMany(mappedBy = "ticket")
    private List<Estudio> estudioList;

    public Ticket() {
    }

    public Ticket(DatosFacturacion datosFacturacion, LocalDate fecha, LocalTime hora, Boolean requiereFactura, Character estado, BigDecimal total) {
        this.datosFacturacion = datosFacturacion;
        this.fecha = fecha;
        this.hora = hora;
        this.requiereFactura = requiereFactura;
        this.estado = estado;
        this.total = total;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatosFacturacion getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(DatosFacturacion datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Boolean getRequiereFactura() {
        return requiereFactura;
    }

    public void setRequiereFactura(Boolean requiereFactura) {
        this.requiereFactura = requiereFactura;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<FotoTicket> getFotoTicket() {
        return fotoTicket;
    }

    public void setFotoTicket(List<FotoTicket> fotoTicket) {
        this.fotoTicket = fotoTicket;
    }

    public List<PagoTicket> getPagoTicketList() {
        return pagoTicketList;
    }

    public void setPagoTicketList(List<PagoTicket> pagoTicketList) {
        this.pagoTicketList = pagoTicketList;
    }

    public List<Estudio> getEstudioList() {
        return estudioList;
    }

    public void setEstudioList(List<Estudio> estudioList) {
        this.estudioList = estudioList;
    }
}
