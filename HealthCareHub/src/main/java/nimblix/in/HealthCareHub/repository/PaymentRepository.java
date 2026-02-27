package nimblix.in.HealthCareHub.repository;

import java.util.Optional;
import java.util.List;
import nimblix.in.HealthCareHub.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payment by transactionId (for refund)
    Optional<Payment> findByTransactionId(String transactionId);

    Optional<Payment> findByAppointmentId(Long appointmentId);

    // Get all payments for a specific appointment (if needed later)
    <Appointment> List<Payment> findAllByAppointment(Appointment appointment);

    // Get payments by status (SUCCESS, PARTIAL, REFUNDED)
    List<Payment> findByPaymentStatus(String paymentStatus);

}