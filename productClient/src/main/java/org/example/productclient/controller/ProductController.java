package org.example.productclient.controller;

import ir.digixo.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.example.productclient.entity.Product;
import org.example.productclient.repository.ProductRepository;
import org.example.productclient.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProduct() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return productService.findById(id);
    }
}
