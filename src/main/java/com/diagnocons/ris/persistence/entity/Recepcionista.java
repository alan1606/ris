package com.diagnocons.ris.persistence.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "recepcionista")
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "primer_nombre", length = 20)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;

    @Column(name = "apellido_paterno",length = 20)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 20)
    private String apellidoMaterno;

    private Character sexo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "recepcionista")
    private List<Corte> corteList;

    @OneToMany(mappedBy = "recepcionista")
    private List<RecepcionistaDepartamento> recepcionistaDepartamentoList;

    @OneToMany(mappedBy = "recepcionista")
    private List<Cita> citaList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Corte> getCorteList() {
        return corteList;
    }

    public void setCorteList(List<Corte> corteList) {
        this.corteList = corteList;
    }

    public List<RecepcionistaDepartamento> getRecepcionistaDepartamentoList() {
        return recepcionistaDepartamentoList;
    }

    public void setRecepcionistaDepartamentoList(List<RecepcionistaDepartamento> recepcionistaDepartamentoList) {
        this.recepcionistaDepartamentoList = recepcionistaDepartamentoList;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }
}
