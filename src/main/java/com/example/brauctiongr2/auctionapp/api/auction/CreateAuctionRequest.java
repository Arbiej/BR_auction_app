package com.example.brauctiongr2.auctionapp.api.auction;

import com.sun.istack.NotNull;
import lombok.Value;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Value
class CreateAuctionRequest {


    @Min(1)
    private final long ownerId;
    @Min(1)
    private final long ownerAccountNumber;

    @NotBlank
    private final String title;

    @NotBlank
    private final String description;

    @Min(1)
    private final int quantity;

    @DecimalMin("0.01")
    private final BigDecimal price;

    @Min(1)
    private final int expirationDays;
}

