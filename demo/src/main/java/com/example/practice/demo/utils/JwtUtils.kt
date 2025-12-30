package com.example.practice.demo.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*


object JwtUtils {


    val key = Keys.secretKeyFor(SignatureAlgorithm.HS256)


    fun generateToken(userEmail: String): String {
        return Jwts.builder()
            .setSubject(userEmail)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60)) //1 hr
            .signWith(key)
            .compact()
    }

    fun extractUsername(token: String?): String {
        return Jwts.parser().setSigningKey(key)
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun validate(token: String): Boolean {
        return !isExpired(token)
    }

    private fun isExpired(token: String): Boolean {
        return Jwts.parser().setSigningKey(key)
            .parseClaimsJws(token)
            .body
            .expiration
            .before(Date())
    }

}