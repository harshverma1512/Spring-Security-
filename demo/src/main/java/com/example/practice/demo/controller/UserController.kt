package com.example.practice.demo.controller

import com.example.practice.demo.model.UserModel
import com.example.practice.demo.model.UserResponse
import com.example.practice.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@Component
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @GetMapping("/login")
    fun getUser(
        @RequestParam("email") email: String,
        @RequestParam("password") password: String
    ): ResponseEntity<UserResponse> {

        return try {
            val user = userService.getUser(email, password)
                ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    UserResponse(
                        status = HttpStatus.UNAUTHORIZED,
                        data = null,
                        message = "Invalid email or password"
                    )
                )

            ResponseEntity.ok(
                UserResponse(
                    status = HttpStatus.OK,
                    data = user,
                    message = "Login successful"
                )
            )

        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                UserResponse(
                    status = HttpStatus.BAD_REQUEST,
                    data = null,
                    message = e.message ?: "Something went wrong"
                )
            )
        }
    }

    @PostMapping("/signup")
    fun saveUser(@RequestBody user : UserModel) : ResponseEntity<UserResponse> {
        val userExists = userService.getUser(user.email!!, passwordEncoder.encode(user.password))

        try {
            if (userExists != null) return ResponseEntity.status(HttpStatus.CONFLICT).body(
                UserResponse(
                    status = HttpStatus.CONFLICT,
                    data = null,
                    message = "User already exists"
                )
            )else{
                user.password = passwordEncoder.encode(user.password)
                userService.saveUser(user)
                return ResponseEntity.ok(UserResponse(status = HttpStatus.CREATED, data = user, message = "User created successfully"))
            }
        }catch (e: Exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
            body(UserResponse(status = HttpStatus.BAD_REQUEST, data = null,
                message = e.message ?:"Something went wrong"))
        }

    }


}