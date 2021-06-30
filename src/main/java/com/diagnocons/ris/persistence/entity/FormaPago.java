package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forma_pago")
public class FormaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descpripcion", length = 20)
    private String descripcion;

    @OneToMany(mappedBy = "formaPago")
    private List<PagoTicket> pagoTicket;

    public FormaPago() {
    }

    public FormaPago(String descripcion, List<PagoTicket> pagoTicket) {
        this.descripcion = descripcion;
        this.pagoTicket = pagoTicket;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PagoTicket> getPagoTicket() {
        return pagoTicket;
    }

    public void setPagoTicket(List<PagoTicket> pagoTicket) {
        this.pagoTicket = pagoTicket;
    }
}
