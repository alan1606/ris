package com.diagnocons.ris.domain.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Movement {
    private Long idMovement;
    private Long idCut;
    private BigDecimal quantity;
    private String description;
    private LocalTime hour;
    private boolean entry;

    public Long getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(Long idMovement) {
        this.idMovement = idMovement;
    }

    public Long getIdCut() {
        return idCut;
    }

    public void setIdCut(Long idCut) {
        this.idCut = idCut;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public boolean isEntry() {
        return entry;
    }

    public void setEntry(boolean entry) {
        this.entry = entry;
    }
}
