package com.example.brauctiongr2.auctionapp.domain.order;

import com.example.brauctiongr2.auctionapp.domain.auction.Auction;
import com.example.brauctiongr2.auctionapp.sherable.Auditable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@Table(name = "ORDERS")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence")
    private long id;
    private long auctionId;
    private long ownerAccountNumber;
    private BigDecimal itemPrice;
    private long clientId;
    private String clientAccountNumber;
    private int quantity;
    @Setter
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    static Order makePending(OrderResponse orderResponse, Auction auction) {
        Order order = Order.builder().auctionId(orderResponse.getAuctionId())
                .ownerAccountNumber(auction.getOwnerAccountNumber())
                .itemPrice(auction.getPrice())
                .clientId(orderResponse.getClientId())
                .clientAccountNumber(orderResponse.getClientAccountNumber())
                .quantity(orderResponse.getQuantity())
                .status(OrderStatus.PENDING)
                .build();
        return order;
    }
    public void setPaidOrderStatus(){
        this.status=OrderStatus.PAID;
    }
}