package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PartialPaymentRequest {

    @NotNull
    private Long appointmentId;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private String transactionId;

    //  GETTERS & SETTERS

    public Long getAppointmentId() {
        return appointmentId;
    }

    public long getPatientId(){
        return getPatientId();
    }

    public String getPaymentMethod(){
        return getPaymentMethod();
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}