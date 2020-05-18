package com.example.brauctiongr2.auctionapp.infrastructure.auction;


import com.example.brauctiongr2.auctionapp.domain.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}
