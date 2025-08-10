package org.example.productclient.service;

import ir.digixo.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.example.productclient.entity.Product;
import org.example.productclient.mapper.ProductMapper;
import org.example.productclient.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper; // حذف ProductMapper.INSTANCE
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        products.forEach(product -> {
            dtos.add(mapper.toDto(product));
        });
        return dtos;
    }

    public ProductDTO findById(Integer id) {
        Product products = productRepository.findById(id).get();
        return mapper.toDto(products);
    }
}
