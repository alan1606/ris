package com.diagnocons.ris.domain.dto;

import java.time.LocalTime;

public class Turn {
    private Long idTurn;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Long getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Long idTurn) {
        this.idTurn = idTurn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
