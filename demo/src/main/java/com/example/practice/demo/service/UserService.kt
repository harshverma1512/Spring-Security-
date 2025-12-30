package com.example.practice.demo.service

import com.example.practice.demo.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.practice.demo.repository.UserRepository
import com.example.practice.demo.utils.JwtUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException


@Service
open class UserService  : UserDetailsService{

    @Autowired
    val userRepository: UserRepository? = null
    @Autowired
    val authenticationManager: AuthenticationManager? = null

    fun getUser(email : String , password : String) : UserModel? {
        authenticationManager?.authenticate(UsernamePasswordAuthenticationToken(email, password))
        val user = userRepository?.findByEmail(email)
        val jwtToken = JwtUtils.generateToken(email)
        return user?.copy(token = jwtToken)
    }


    fun saveUser(user : UserModel) {
        userRepository?.save(user)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
       val response = userRepository?.findByEmail(username)
        response?: throw UsernameNotFoundException("User Not Found")
        return org.springframework.security.core.userdetails.User(
            response.email,
            response.password, emptyList()
        )
    }

}