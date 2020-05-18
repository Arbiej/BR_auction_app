package com.example.brauctiongr2.auctionapp.domain.auction;

public interface QuantityChanger {
    void changeQuantity(Auction auction, int reduceQuantityItems);
}
