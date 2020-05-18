package com.example.brauctiongr2.auctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuctionQuantityChanger implements QuantityChanger {


    @Override
    public void changeQuantity(Auction auction, int reduceQuantityItems) {
        auction.reduceQuantityAndUpdateStatus(reduceQuantityItems);
    }
}
