package com.diagnocons.ris.domain.dto;

public class BillingData {
    private Long idBillingData;
    private String businessName;
    private String rfc;
    private String cp;
    private String email;
    private String phone;

    public Long getIdBillingData() {
        return idBillingData;
    }

    public void setIdBillingData(Long idBillingData) {
        this.idBillingData = idBillingData;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
