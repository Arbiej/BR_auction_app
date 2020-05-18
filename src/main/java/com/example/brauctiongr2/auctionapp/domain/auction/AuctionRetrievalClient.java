package com.example.brauctiongr2.auctionapp.domain.auction;

public interface AuctionRetrievalClient {
    Auction getActiveAuctionByIdOrThrow(long id);
}
