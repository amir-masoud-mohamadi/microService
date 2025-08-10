package org.example.productclient.mapper;

import ir.digixo.product.ProductDTO;
import org.example.productclient.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import javax.print.attribute.standard.Media;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    // حذف INSTANCE چون دیگر نیازی نیست
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
}
