package com.diagnocons.ris.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class TicketDTO {
    private Long idTicket;
    private Long idBillingData;
    private LocalDate date;
    private LocalTime hour;
    private boolean requiresInvoice;
    private char state;
    private BigDecimal total;

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdBillingData() {
        return idBillingData;
    }

    public void setIdBillingData(Long idBillingData) {
        this.idBillingData = idBillingData;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public boolean isRequiresInvoice() {
        return requiresInvoice;
    }

    public void setRequiresInvoice(boolean requiresInvoice) {
        this.requiresInvoice = requiresInvoice;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
