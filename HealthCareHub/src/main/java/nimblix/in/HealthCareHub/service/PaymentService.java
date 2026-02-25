package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.CreatePaymentRequest;
import nimblix.in.HealthCareHub.request.RefundRequest;
import nimblix.in.HealthCareHub.request.PartialPaymentRequest;
import nimblix.in.HealthCareHub.response.PaymentResponse;
import nimblix.in.HealthCareHub.response.TransactionHistoryResponse;

public interface PaymentService {

    // Create full payment
    PaymentResponse createPayment(CreatePaymentRequest request);
    // Refund payment using transaction ID
    PaymentResponse refundPayment(RefundRequest request);

    // Add partial payment
    PaymentResponse partialPayment(PartialPaymentRequest request);

    // Get transaction history by appointment
    TransactionHistoryResponse getTransactionHistory(Long appointmentId);

}