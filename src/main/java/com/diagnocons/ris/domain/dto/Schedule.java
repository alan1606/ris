package com.diagnocons.ris.domain.dto;

import java.time.LocalDate;

public class Schedule {
    private Long idSchedule;
    private LocalDate day;

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}