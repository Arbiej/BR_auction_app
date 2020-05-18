package com.example.brauctiongr2.auctionapp.api.auction;


import com.example.brauctiongr2.auctionapp.api.order.CreateOrdersRequest;
import com.example.brauctiongr2.auctionapp.domain.auction.AuctionFacade;
import com.example.brauctiongr2.auctionapp.domain.auction.AuctionResponse;
import com.example.brauctiongr2.auctionapp.domain.order.OrderResponse;
import com.example.brauctiongr2.auctionapp.domain.order.OrdersFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/auctions")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionFacade auctionFacade;


    @PostMapping
    public void createAuction(@Valid @RequestBody CreateAuctionRequest createAuctionRequest) {

        AuctionResponse auctionResponse = AuctionResponse.builder()
                .ownerId(createAuctionRequest.getOwnerId())
                .ownerAccountNumber(createAuctionRequest.getOwnerAccountNumber())
                .title(createAuctionRequest.getTitle())
                .description(createAuctionRequest.getDescription())
                .quantity(createAuctionRequest.getQuantity())
                .price(createAuctionRequest.getPrice())
                .expirationDays(createAuctionRequest.getExpirationDays())
                .build();
        auctionFacade.createAuction(auctionResponse);

    }
}

