package com.example.brauctiongr2.auctionapp.domain.payment;

import com.example.brauctiongr2.auctionapp.domain.order.Order;

import java.util.List;

public interface PaymentSendToClient {
    void sendPayment(Order order);

}
