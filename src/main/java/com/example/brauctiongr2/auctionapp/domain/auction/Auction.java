package com.example.brauctiongr2.auctionapp.domain.auction;

import com.example.brauctiongr2.auctionapp.sherable.Auditable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
public class Auction extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auction_sequence")
    @SequenceGenerator(name = "auction_sequence")
    private long id;
    private long ownerId;
    private long ownerAccountNumber;
    private String title;
    private String description;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;

    public static Auction generateActiveAuction(AuctionResponse auctionResponse) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        Auction auction = new Auction();
        auction.ownerId=auctionResponse.getOwnerId();
        auction.ownerAccountNumber = auctionResponse.getOwnerAccountNumber();
        auction.title = auctionResponse.getTitle();
        auction.description = auctionResponse.getDescription();
        auction.quantity = auctionResponse.getQuantity();
        auction.price = auctionResponse.getPrice();
        auction.startDate = currentDateTime;
        auction.endDate = currentDateTime.plusDays(auctionResponse.getExpirationDays());
        auction.active = true;
        return auction;
    }

    void reduceQuantityAndUpdateStatus(int reduceByQuantity) {
        this.quantity -= reduceByQuantity;
        if (this.quantity == 0) {
            this.active = false;
        }
    }
}
