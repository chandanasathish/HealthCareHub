package nimblix.in.HealthCareHub.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransactionHistoryResponse {

    private Long appointmentId;

    private List<PaymentResponse> payments;

    public TransactionHistoryResponse(Long appointmentId,List<PaymentResponse>payments){
        this.appointmentId=appointmentId;
        this.payments=payments;
    }

    public TransactionHistoryResponse() {

    }
}
