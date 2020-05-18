package com.example.brauctiongr2.auctionapp.infrastructure.auction;

import com.example.brauctiongr2.auctionapp.domain.auction.Auction;
import com.example.brauctiongr2.auctionapp.domain.auction.AuctionRetrievalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionRetrievalPostgresClient implements AuctionRetrievalClient {
    private final AuctionRepository auctionRepository;

    @Override
    public Auction getActiveAuctionByIdOrThrow(long id){
        Auction auction=auctionRepository.getOne(id);
        if(!auction.isActive()){
            throw  new IllegalArgumentException(String
                    .format("Auction is not active[auctionId=%d]",auction.getId()));
        }
        return auction;
    }
}
