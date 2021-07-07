package com.diagnocons.ris.domain.dto;

import java.time.LocalTime;

public class ScheduleDepartment {
    private Long idScheduleDepartment;
    private Long idSchedule;
    private Long idDepartment;
    private LocalTime startHour;
    private LocalTime endHour;

    public Long getIdScheduleDepartment() {
        return idScheduleDepartment;
    }

    public void setIdScheduleDepartment(Long idScheduleDepartment) {
        this.idScheduleDepartment = idScheduleDepartment;
    }

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }
}
