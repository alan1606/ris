package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pago_ticket")
public class PagoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_ticket", insertable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_forma_pago", updatable = false, insertable = false)
    private FormaPago formaPago;

    @Column(name = "cantidad")
    private BigDecimal cantidad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
}


