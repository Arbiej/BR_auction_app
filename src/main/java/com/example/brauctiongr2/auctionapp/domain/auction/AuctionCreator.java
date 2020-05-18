package com.example.brauctiongr2.auctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class AuctionCreator {

    private final CreateAuctionClient createAuctionClient;


    @Transactional
    public void create(AuctionResponse auctionResponse) {
        Auction auction = Auction.generateActiveAuction(auctionResponse);
        createAuctionClient.create(auction);
    }
}
