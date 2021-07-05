package com.diagnocons.ris.persistence.entity;



import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "corte")
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Hay que ignorarlo
    @OneToOne
    @JoinColumn(name = "id_turno", insertable = false, updatable = false)
    private Turno turno;

    @OneToOne
    @JoinColumn(name = "id_recepcionista_responsable", insertable = false, updatable = false)
    private Recepcionista recepcionista;

    private LocalDate dia;

    @Column(name = "fondo_caja")
    private BigDecimal fondoCaja;

    @OneToMany(mappedBy = "corte")
    private List<Movimiento> movimientoList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public BigDecimal getFondoCaja() {
        return fondoCaja;
    }

    public void setFondoCaja(BigDecimal fondoCaja) {
        this.fondoCaja = fondoCaja;
    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }
}
