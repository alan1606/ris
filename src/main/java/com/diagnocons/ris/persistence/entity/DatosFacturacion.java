package com.diagnocons.ris.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "datos_facturacion")
public class DatosFacturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social", length = 100)
    private String razonSocial;

    @Column(name = "rfc", length = 13)
    private String rfc;

    @Column(name = "cp", length = 8)
    private String cp;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "telefono", length = 13)
    private String telefono;

    @OneToMany(mappedBy = "datosFacturacion")
    private List<Convenio> convenio;

    @OneToMany(mappedBy = "datosFacturacion")
    private List<Persona> personaList;

    @OneToMany(mappedBy = "datosFacturacion")
    private List<Ticket> ticketList;

    public DatosFacturacion() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Convenio> getConvenio() {
        return convenio;
    }

    public void setConvenio(List<Convenio> convenio) {
        this.convenio = convenio;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
