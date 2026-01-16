package com.example.practice.demo.service

import com.example.practice.demo.model.Restaurant
import com.example.practice.demo.repository.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RestaurantService {

    @Autowired
    lateinit var restaurantRepository: RestaurantRepository


    // fetch All restaurants
    fun getAllRestaurants() = restaurantRepository.findAll()


    fun addRestaurant(restaurant: Restaurant){
        restaurantRepository.save(restaurant)
    }


    fun restaurantIsOpenClosed(id : Int ,isOpen: Boolean){
       val restaurant =  restaurantRepository.findById(id)
        restaurant.get().is_open = isOpen
    }


    fun getRestaurantByName(name : String) = restaurantRepository.getRestaurantByName(name)


    



}