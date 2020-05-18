package com.example.brauctiongr2.auctionapp.domain.order;

import com.example.brauctiongr2.auctionapp.domain.payment.Payment;
import com.example.brauctiongr2.auctionapp.domain.payment.PaymentSendToClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersFacade {

    private final OrdersCreator ordersCreator;
    private final OrderRetrievalClient orderRetrievalClient;
    private final StatusChanger statusChanger;


    public void createOrder(OrderResponse orderResponse){
        ordersCreator.createOrderAndAmendAuction(orderResponse);
    }
     public void createPayment (long orderId) {
         ordersCreator.createPayment(orderId);
     }
    @Transactional
     public void changeStatus(long orderId){
        Order orderPaid=orderRetrievalClient.getOrder(orderId);
        statusChanger.changeStatus(orderPaid);
        }



    @Transactional
    public List<Payment> getAllPaymentsByOrderStatus() {
        List<Order> pendingOrders=orderRetrievalClient.getPendingOrders();
        for(Order order: pendingOrders){
            order.setPaidOrderStatus();
        }
        return pendingOrders
                .stream()
                .map(Payment::generatePayment)
                .collect(Collectors.toList());
    }
}
