package com.example.brauctiongr2.auctionapp.domain.order;

import com.example.brauctiongr2.auctionapp.domain.auction.Auction;
import com.example.brauctiongr2.auctionapp.domain.auction.AuctionRetrievalClient;
import com.example.brauctiongr2.auctionapp.domain.auction.QuantityChanger;
import com.example.brauctiongr2.auctionapp.domain.payment.PaymentSendToClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class OrdersCreator {

    private final AuctionRetrievalClient auctionRetrievalClient;
    private final CreateOrderClient createOrderClient;
    private final QuantityChanger quantityChanger;
    private final PaymentSendToClient paymentSender;
    private final OrderRetrievalClient orderRetrievalClient;

    @Transactional
    public void createOrderAndAmendAuction(OrderResponse orderResponse) {
        Auction auction = auctionRetrievalClient.getActiveAuctionByIdOrThrow(orderResponse.getAuctionId());
        if (auction.getQuantity() >= orderResponse.getQuantity()) {
            Order order = Order.makePending(orderResponse, auction);
            createOrderClient.create(order);
            quantityChanger.changeQuantity(auction, order.getQuantity());
        } else {
            throw new IllegalArgumentException(String
                    .format("Quantity is not sufficient to place order [Order quantity =%d] [Auction quantity=%d] ",
                            orderResponse.getQuantity(),
                            auction.getQuantity()));
        }
    }

    @Transactional
    public void createPayment(long orderId) {
        Order payOrder = orderRetrievalClient.getOrder(orderId);
        paymentSender.sendPayment(payOrder);
    }
}


