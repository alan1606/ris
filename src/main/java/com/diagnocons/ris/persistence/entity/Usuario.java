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
    @JoinColumn(name = "idTipoUsuario", insertable=false, updatable = false)
    private TipoUsuario tipoUsuario;

    private String nick;

    private String pass;

    private String nip;

    private String email;

    private String phoneNumber;

    private Boolean activeUser;

    private String replaceId;

    private Boolean validated;

    @OneToMany(mappedBy = "usuario")
    private List<PermisoUsuario> permisoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<FotoUsuario> fotoUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
