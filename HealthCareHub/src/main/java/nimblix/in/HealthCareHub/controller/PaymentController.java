package nimblix.in.HealthCareHub.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nimblix.in.HealthCareHub.request.CreatePaymentRequest;
import nimblix.in.HealthCareHub.request.RefundRequest;
import nimblix.in.HealthCareHub.request.PartialPaymentRequest;
import nimblix.in.HealthCareHub.response.PaymentResponse;
import nimblix.in.HealthCareHub.response.TransactionHistoryResponse;
import nimblix.in.HealthCareHub.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //  Create Full Payment
    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> createPayment(
            @Valid @RequestBody CreatePaymentRequest request) {

        return ResponseEntity.ok(paymentService.createPayment(request));
    }

    //  Refund Payment
    @PostMapping("/refund")
    public ResponseEntity<PaymentResponse> refundPayment(
            @Valid @RequestBody RefundRequest request) {

        return ResponseEntity.ok(paymentService.refundPayment(request));
    }

    //  Partial Payment
    @PostMapping("/partial")
    public ResponseEntity<PaymentResponse> partialPayment(
            @Valid @RequestBody PartialPaymentRequest request) {

        return ResponseEntity.ok(paymentService.partialPayment(request));
    }

    //  Get Transaction History by Appointment ID
    @GetMapping("/history/{appointmentId}")
    public ResponseEntity<TransactionHistoryResponse> getTransactionHistory(
            @PathVariable Long appointmentId) {

        return ResponseEntity.ok(paymentService.getTransactionHistory(appointmentId));
    }
}