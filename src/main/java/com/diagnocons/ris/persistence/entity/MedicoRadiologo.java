package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medico_radiologo")
public class MedicoRadiologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
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

    @Column(name = "firma", length = 20)
    private String firma;

    @Column(name = "especialidad", length = 50)
    private String especialidad;

    @Column(name = "cedula_federal", length = 20)
    private String cedulaFederal;

    @Column(name = "cedula_estatal", length = 20)
    private String cedulaEstatal;

    @OneToMany(mappedBy = "medicoRadiologo")
    private List<Dictamen> dictamenList;

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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedulaFederal() {
        return cedulaFederal;
    }

    public void setCedulaFederal(String cedulaFederal) {
        this.cedulaFederal = cedulaFederal;
    }

    public String getCedulaEstatal() {
        return cedulaEstatal;
    }

    public void setCedulaEstatal(String cedulaEstatal) {
        this.cedulaEstatal = cedulaEstatal;
    }

    public List<Dictamen> getDictamenList() {
        return dictamenList;
    }

    public void setDictamenList(List<Dictamen> dictamenList) {
        this.dictamenList = dictamenList;
    }
}
