package com.example.brauctiongr2.auctionapp.infrastructure.order;

import com.example.brauctiongr2.auctionapp.domain.order.Order;
import com.example.brauctiongr2.auctionapp.domain.order.OrderRetrievalClient;
import com.example.brauctiongr2.auctionapp.domain.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersRetrievalPostgresClient implements OrderRetrievalClient {

    private final OrdersRepository ordersRepository;

    @Override
    public List<Order> getPendingOrders() {
            return ordersRepository.getAllByStatus(OrderStatus.PENDING);
    }

    @Override
    public Order getOrder(long orderId) {
        return ordersRepository.findOrderById(orderId);
    }
}
