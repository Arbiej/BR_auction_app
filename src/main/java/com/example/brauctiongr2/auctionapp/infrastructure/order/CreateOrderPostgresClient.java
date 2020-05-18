package com.example.brauctiongr2.auctionapp.infrastructure.order;

import com.example.brauctiongr2.auctionapp.domain.order.CreateOrderClient;
import com.example.brauctiongr2.auctionapp.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderPostgresClient implements CreateOrderClient {
private final OrdersRepository ordersRepository;


    @Override
    public void create(Order orders) {
        ordersRepository.save(orders);
    }
}
