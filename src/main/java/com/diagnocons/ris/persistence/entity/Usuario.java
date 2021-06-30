package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario", insertable=false, updatable = false)
    private TipoUsuario tipoUsuario;

    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    private String nick;

    private String pass;

    private String nip;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "active_user")
    private Boolean activeUser;

    @Column(name = "replace_id")
    private String replaceId;

    private Boolean validated;

    /*@OneToMany(mappedBy = "usuario")
    private List<PermisoUsuario> permisoUsuario;*/

    @OneToMany(mappedBy = "usuario")
    private List<FotoUsuario> fotoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Persona> personaList;

    @OneToMany(mappedBy = "usuario")
    private List<MedicoRadiologo> medicoRadiologoList;

    @OneToMany(mappedBy = "usuario")
    private List<Tecnico> tecnicoList;

    @OneToMany(mappedBy = "usuario")
    private List<Recepcionista> recepcionistaList;

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Boolean activeUser) {
        this.activeUser = activeUser;
    }

    public String getReplaceId() {
        return replaceId;
    }

    public void setReplaceId(String replaceId) {
        this.replaceId = replaceId;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    /*public List<PermisoUsuario> getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(List<PermisoUsuario> permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }*/

    public List<FotoUsuario> getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(List<FotoUsuario> fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<MedicoRadiologo> getMedicoRadiologoList() {
        return medicoRadiologoList;
    }

    public void setMedicoRadiologoList(List<MedicoRadiologo> medicoRadiologoList) {
        this.medicoRadiologoList = medicoRadiologoList;
    }

    public List<Tecnico> getTecnicoList() {
        return tecnicoList;
    }

    public void setTecnicoList(List<Tecnico> tecnicoList) {
        this.tecnicoList = tecnicoList;
    }

    public List<Recepcionista> getRecepcionistaList() {
        return recepcionistaList;
    }

    public void setRecepcionistaList(List<Recepcionista> recepcionistaList) {
        this.recepcionistaList = recepcionistaList;
    }
}
