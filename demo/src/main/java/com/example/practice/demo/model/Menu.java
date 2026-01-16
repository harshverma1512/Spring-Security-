package com.example.practice.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menu")
public class Menu {

    @Id
    int id;
    String dishName;
    int price;
   DishQuantity quantity;


    public enum DishQuantity {
        Half,
        Full,
    }
}

