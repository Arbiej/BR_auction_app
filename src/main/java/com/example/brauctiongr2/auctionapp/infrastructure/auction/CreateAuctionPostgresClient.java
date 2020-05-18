package com.example.brauctiongr2.auctionapp.infrastructure.auction;

import com.example.brauctiongr2.auctionapp.domain.auction.Auction;
import com.example.brauctiongr2.auctionapp.domain.auction.CreateAuctionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAuctionPostgresClient implements CreateAuctionClient {

    private final AuctionRepository auctionRepository;

    @Override
    public void create(Auction auction) {
        auctionRepository.save(auction);
    }
}

