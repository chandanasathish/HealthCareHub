package nimblix.in.HealthCareHub.response;

import java.time.LocalDateTime;

public class PaymentResponse {

    private Long id;
    private Long appointmentId;
    private Long patientId;
    private Double amount;
    private Double paidAmount;
    private String paymentMethod;
    private String transactionId;
    private String status;
    private LocalDateTime paymentDate;

    // ✅ No-Args Constructor
    public PaymentResponse() {
    }

    // All-Args Constructor
    public PaymentResponse(Long id,
                           Long appointmentId,
                           Long patientId,
                           Double amount,
                           Double paidAmount,
                           String paymentMethod,
                           String transactionId,
                           String status,
                           LocalDateTime paymentDate) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    //  Getters & Setters

    public Long getId() {
        return id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentId(Long id) {
    }
}