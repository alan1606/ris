package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "fotoTicket")
public class FotoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTicket", updatable = false, insertable = false)
    private Ticket ticket;

    @Column(name = "ruta", length = 40)
    private String ruta;

    public FotoTicket() {
    }

    public FotoTicket(Ticket ticket, String ruta) {
        this.ticket = ticket;
        this.ruta = ruta;
    }

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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
