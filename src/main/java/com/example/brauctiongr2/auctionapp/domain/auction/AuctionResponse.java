package com.example.brauctiongr2.auctionapp.domain.auction;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Builder
@Getter

public class AuctionResponse {

    @NonNull
    private final long ownerId;
    @NonNull
    private final long ownerAccountNumber;
    @NonNull
    private final String title;
    @NonNull
    private final String description;
    @NonNull
    private final int quantity;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final int expirationDays;
}
