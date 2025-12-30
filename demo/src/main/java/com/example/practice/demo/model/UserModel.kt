package com.example.practice.demo.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "users")
data class UserModel(
    @Id
     val id: String? = null,
     val name: String? = null,
    @Indexed(unique = true)
     val email: String? = null,
     var password: String? = null,
     val token: String? = null,
     val role: String? = "USER"
)
