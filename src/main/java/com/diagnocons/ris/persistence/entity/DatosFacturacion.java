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

    @OneToOne(mappedBy = "datosFacturacion")
    private Convenio convenio;

    @OneToOne(mappedBy = "datosFacturacion")
    private Persona persona;

    @OneToMany(mappedBy = "datosFacturacion")
    private List<Ticket> ticketList;


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

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
