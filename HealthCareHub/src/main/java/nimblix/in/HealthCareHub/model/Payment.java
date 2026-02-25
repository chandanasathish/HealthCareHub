package nimblix.in.HealthCareHub.model;

import jakarta.persistence.*;
import lombok.Data;
import nimblix.in.HealthCareHub.model.Payment;

import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appointmentId;
    private Long patientId;

    private Double amount;
    private String paymentMethod;
    private String transactionId;
    private String status;

    private LocalDateTime paymentDate;
}