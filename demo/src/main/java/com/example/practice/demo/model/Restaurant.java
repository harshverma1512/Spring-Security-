package com.example.practice.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "restaurant")
public class Restaurant {

    @Id
    int id;
    String name;
    String address;
    String zipcode;
    String phone;
    List<Menu> menus;
   public Boolean is_open;
    int rating;

}
