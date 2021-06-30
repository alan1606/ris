package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dictamen")
public class Dictamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_medico_radiologo", insertable = false, updatable = false)
    private MedicoRadiologo medicoRadiologo;

    @ManyToOne
    @JoinColumn(name = "id_estudio", insertable = false, updatable = false)
    private Estudio estudio;

    private LocalDate fecha;

    @Column(name = "interpretacion", length = 16777215)
    private String interpretacion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicoRadiologo getMedicoRadiologo() {
        return medicoRadiologo;
    }

    public void setMedicoRadiologo(MedicoRadiologo medicoRadiologo) {
        this.medicoRadiologo = medicoRadiologo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }
}
