package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import nimblix.in.HealthCareHub.model.Payment;
import nimblix.in.HealthCareHub.repository.PaymentRepository;
import nimblix.in.HealthCareHub.request.CreatePaymentRequest;
import nimblix.in.HealthCareHub.request.RefundRequest;
import nimblix.in.HealthCareHub.request.PartialPaymentRequest;
import nimblix.in.HealthCareHub.response.PaymentResponse;
import nimblix.in.HealthCareHub.response.TransactionHistoryResponse;
import nimblix.in.HealthCareHub.service.PaymentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    //  Create Full Payment
    @Override
    public PaymentResponse createPayment(CreatePaymentRequest request) {

        Payment payment = new Payment();
        payment.setAppointmentId(request.getAppointmentId());
        payment.setPatientId(request.getPatientId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setTransactionId(request.getTransactionId());
        payment.setStatus("SUCCESS");
        payment.setPaymentDate(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);

        return mapToResponse(savedPayment);
    }

    // Refund Payment
    @Override
    public PaymentResponse refundPayment(RefundRequest request) {

        Payment payment = paymentRepository
                .findByTransactionId(request.getTransactionId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        payment.setStatus("REFUNDED");

        Payment updatedPayment = paymentRepository.save(payment);

        return mapToResponse(updatedPayment);
    }

    // Partial Payment
    @Override
    public PaymentResponse partialPayment(PartialPaymentRequest request) {

        Payment payment = new Payment();
        payment.setAppointmentId(request.getAppointmentId());
        payment.setPatientId(request.getPatientId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setTransactionId(request.getTransactionId());
        payment.setStatus("PARTIAL");
        payment.setPaymentDate(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);

        return mapToResponse(savedPayment);
    }

    // Transaction History
    @Override
    public TransactionHistoryResponse getTransactionHistory(Long appointmentId) {

        Optional<Payment> payments = paymentRepository.findByAppointmentId(appointmentId);

        List<PaymentResponse> paymentResponses = payments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        TransactionHistoryResponse response = new TransactionHistoryResponse();
        response.setAppointmentId(appointmentId);
        response.setPayments(paymentResponses);

        return response;
    }

    // Common Mapper Method
    private PaymentResponse mapToResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setAppointmentId(payment.getAppointmentId());
        response.setPatientId(payment.getPatientId());
        response.setAmount(payment.getAmount());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setTransactionId(payment.getTransactionId());
        response.setStatus(payment.getStatus());
        response.setPaymentDate(payment.getPaymentDate());

        return response;
    }
}