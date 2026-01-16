package com.example.practice.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "servingItems")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingItems {

    @Id
    int id;
    String servingDishName;
    int servingDishQuantity;
}
