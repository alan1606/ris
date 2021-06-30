package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "limite_estudios_diarios")
public class LimiteEstudiosDiarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_departamento", updatable = false, insertable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_convenio", updatable = false, insertable = false)
    private Convenio convenio;

    private Long limite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Long getLimite() {
        return limite;
    }

    public void setLimite(Long limite) {
        this.limite = limite;
    }
}
