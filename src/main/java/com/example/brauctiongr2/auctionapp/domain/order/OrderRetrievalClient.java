package com.example.brauctiongr2.auctionapp.domain.order;

import java.util.List;

public interface OrderRetrievalClient{
    List<Order> getPendingOrders();
    Order getOrder(long id);
}