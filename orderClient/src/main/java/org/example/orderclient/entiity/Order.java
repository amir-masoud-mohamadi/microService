package org.example.orderclient.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId; // فقط ID محصول را نگه می‌داریم

    private String customerEmail;

    private Integer quantity;

    private BigDecimal totalPrice;

    // constructors, getters, setters
}
