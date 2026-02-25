package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RefundRequest {

    @NotBlank(message = "Transaction ID is required")
    private String transactionId;

}
