package com.example.brauctiongr2.auctionapp.infrastructure.payment;
import com.example.brauctiongr2.auctionapp.domain.order.Order;
import com.example.brauctiongr2.auctionapp.domain.payment.Payment;
import com.example.brauctiongr2.auctionapp.domain.payment.PaymentSendToClient;
import com.example.brauctiongr2.auctionapp.infrastructure.order.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
 public  class PaymentRestSender implements PaymentSendToClient {

    private final RestTemplate restTemplate;
    private final String transferBankAppUrl;

    @Autowired
    public PaymentRestSender(RestTemplate restTemplate,
                             @Value("${send.payment.bankapp.url}")String transferBankAppUrl){

        this.restTemplate=restTemplate;
        this.transferBankAppUrl=transferBankAppUrl;
    }

    @Override
    public void sendPayment(Order order) {
        HttpEntity<Payment> requestEntity=new HttpEntity<>(Payment.generatePayment(order));
        restTemplate.exchange(transferBankAppUrl,
                HttpMethod.POST,
                requestEntity,
                Void.class);

    }
}
