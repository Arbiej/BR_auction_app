package com.example.brauctiongr2.auctionapp.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 class OrderStatusChanger implements StatusChanger{

    @Override
    public void changeStatus(Order order){
        order.setPaidOrderStatus();
    }
}
