package com.example.brauctiongr2.auctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionFacade {

    private final AuctionCreator auctionCreator;

    public void createAuction(AuctionResponse auctionResponse) {
        auctionCreator.create(auctionResponse);
    }
}



