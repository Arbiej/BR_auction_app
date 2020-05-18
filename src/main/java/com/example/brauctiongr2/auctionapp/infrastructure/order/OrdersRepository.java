package com.example.brauctiongr2.auctionapp.infrastructure.order;

import com.example.brauctiongr2.auctionapp.domain.order.Order;
import com.example.brauctiongr2.auctionapp.domain.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {
List<Order> getAllByStatus(OrderStatus orderStatus);
Order findOrderById(long id);
}