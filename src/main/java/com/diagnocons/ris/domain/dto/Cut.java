package com.diagnocons.ris.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cut {
    private Long idCut;
    private Long idTurn;
    private Long idReceptionist;
    private LocalDate day;
    private BigDecimal cashFound;

    public Long getIdCut() {
        return idCut;
    }

    public void setIdCut(Long idCut) {
        this.idCut = idCut;
    }

    public Long getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Long idTurn) {
        this.idTurn = idTurn;
    }

    public Long getIdReceptionist() {
        return idReceptionist;
    }

    public void setIdReceptionist(Long idReceptionist) {
        this.idReceptionist = idReceptionist;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public BigDecimal getCashFound() {
        return cashFound;
    }

    public void setCashFound(BigDecimal cashFound) {
        this.cashFound = cashFound;
    }
}
