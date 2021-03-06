package com.example.brauctiongr2.auctionapp.api.order;

import lombok.Value;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Value
public class CreateOrdersRequest {

    @Min(1)
    private final long clientId;
    @NotBlank
    private final String clientAccountNumber;
    @Min(1)
    private final int quantity;
}
