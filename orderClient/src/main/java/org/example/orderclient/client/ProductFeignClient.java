package org.example.orderclient.client;

import ir.digixo.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE") // نام سرویس در Eureka
public interface ProductFeignClient {

    @GetMapping("/products") // همانند کنترلر واقعی
    String getProduct();

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
