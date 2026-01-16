package com.example.practice.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Orders {
    @Id
    private int userId;
    private String userName;
    @DBRef
    private ServingItems servingItems;
    private int totalPrice;
    private String orderStatus;
    private String orderDate;
    private String paymentStatus;
    private String paymentMode;
    private String userAddress;
    @DBRef
    private Restaurant restaurant;
    private String userPhoneNumber;
}


