package nimblix.in.HealthCareHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nimblix.in.HealthCareHub.utility.HealthCareUtil;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String paymentStatus; // SUCCESS, FAILED, PENDING

    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    @Column(name = "created_time")
    private String createdTime;

    @Column(name = "updated_time")
    private String updatedTime;


    @PrePersist
    protected void onCreate(){
        createdTime= HealthCareUtil.changeCurrentTimeToLocalDateFromGmtToISTInString();
        updatedTime= HealthCareUtil.changeCurrentTimeToLocalDateFromGmtToISTInString();

    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedTime= HealthCareUtil.changeCurrentTimeToLocalDateFromGmtToISTInString();


    }

    public void setAppointmentId(@NotNull(message = "Appointment ID is required") Long appointmentId) {
    }

    public void setPatientId(@NotNull(message = "Patient ID is required") Long patientId) {
    }

    public void setPaymentMethod(@NotBlank(message = "Payment method is required") String paymentMethod) {
    }

    public void setTransactionId(@NotBlank(message = "Transaction ID is required") String transactionId) {
    }

    public void setStatus(String success) {
    }

    public Long getAppointmentId() {
        return getAppointmentId();
    }

    public String getTransactionId() {
        return getTransactionId();
    }

    public Long getPatientId() {
        return getPatientId();
    }

    public String getPaymentMethod() {
        return getPaymentMethod();
    }

    public String getStatus() {
        return getStatus();
    }
}
