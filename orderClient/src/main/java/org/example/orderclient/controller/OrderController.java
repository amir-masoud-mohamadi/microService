package org.example.orderclient.controller;

import org.example.orderclient.client.ProductFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ProductFeignClient productClient;

    // تزریق خودکار Feign Client
    public OrderController(ProductFeignClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping
    public String createOrder() {
        // تماس با سرویس محصولات از طریق Load Balancer
        String productInfo = productClient.getProduct();
        return "سفارش جدید با محصول: " + productInfo;
    }
}
