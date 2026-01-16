package com.example.practice.demo.controller

import com.example.practice.demo.model.Restaurant
import com.example.practice.demo.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/restaurant")
class RestaurantController {

    @Autowired
    private val restaurantService = RestaurantService()

    @GetMapping
    fun getAllRestaurants() = restaurantService.getAllRestaurants()

    @PutMapping("/{id}")
    fun restaurantIsOpenClosed(@PathVariable id: Int, @RequestBody isOpen: Boolean) =
        restaurantService.restaurantIsOpenClosed(id, isOpen)

    @PostMapping("/add")
    fun addRestaurant(@RequestBody restaurant: Restaurant): ResponseEntity<Restaurant> {
        try {
            restaurantService.addRestaurant(restaurant)
            return ResponseEntity.ok(restaurant)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}