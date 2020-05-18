package com.example.brauctiongr2.auctionapp.api.order;

import com.example.brauctiongr2.auctionapp.domain.order.OrderResponse;
import com.example.brauctiongr2.auctionapp.domain.order.OrdersFacade;
import com.example.brauctiongr2.auctionapp.domain.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrdersController {

    private final OrdersFacade ordersFacade;

    @PostMapping(path = "/auction/{auctionId}")
    public void createOrder(@Min(1) @PathVariable long auctionId, @Valid @RequestBody CreateOrdersRequest createOrdersRequest) {
        OrderResponse orderResponse = OrderResponse.builder()
                .auctionId(auctionId)
                .clientId(createOrdersRequest.getClientId())
                .clientAccountNumber(createOrdersRequest.getClientAccountNumber())
                .quantity(createOrdersRequest.getQuantity())
                .build();
        ordersFacade.createOrder(orderResponse);
    }

    @PostMapping(path = "/{orderId}/payment")
    public void createPayment(@PathVariable long orderId) {
        ordersFacade.createPayment(orderId);
    }


    @GetMapping(path = "/pending")
    public ResponseEntity<List<Payment>> getPendingOrders() {
        return ResponseEntity.ok(ordersFacade.getAllPaymentsByOrderStatus());
    }

    @PostMapping(path = "/{orderId}/status}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderStatus(@PathVariable long orderId) {
        ordersFacade.changeStatus(orderId);
    }
}
