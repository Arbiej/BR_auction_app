package com.example.brauctiongr2.auctionapp.domain.payment;

import com.example.brauctiongr2.auctionapp.domain.order.Order;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value= AccessLevel.PRIVATE)

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="payment_sequence")
    @SequenceGenerator(name="payment_sequence")
    private long id;
    private long orderId;
    private long ownerId;
    private long ownerAccountNumber;
    private long clientAccountNumber;
    private BigDecimal totalPrice;
    private String title;

    public static Payment generatePayment(Order order){
        Payment payment =new Payment();
        payment.orderId=order.getId();
        payment.ownerId=order.getClientId();
        payment.ownerAccountNumber=order.getClientId();
        payment.clientAccountNumber=order.getOwnerAccountNumber();
        payment.totalPrice=order.getItemPrice().multiply(new BigDecimal(order.getQuantity()));
        payment.title=String.format("%d, %d", order.getId(),order.getClientId());
        return payment;
    }
}
