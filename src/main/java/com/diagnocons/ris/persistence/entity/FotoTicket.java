package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;


@Entity
@Table(name = "foto_ticket")
public class FotoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ticket", updatable = false, insertable = false)
    private Ticket ticket;

    @Column(name = "ruta", length = 40)
    private String ruta;


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
