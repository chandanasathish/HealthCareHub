package nimblix.in.HealthCareHub.repository;

import java.util.Optional;
import java.util.List;
import nimblix.in.HealthCareHub.model.Payment;
import nimblix.in.HealthCareHub.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payment by transactionId (for refund)
    Optional<Payment> findByTransactionId(String transactionId);

    Optional<Payment> findByAppointmentId(Long appointmentId);

    // Get all payments for a specific appointment (if needed later)
    List<Payment> findAllByAppointment(Appointment appointment);

    // Get payments by status (SUCCESS, PARTIAL, REFUNDED)
    List<Payment> findByPaymentStatus(String paymentStatus);

}
