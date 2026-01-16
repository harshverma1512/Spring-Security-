package com.example.practice.demo.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class UserModel(
    @Id
    val id: String? = null,
    val name: String? = null,
    val email: String? = null,
    var password: String? = null,
    val token: String? = null,
    @DBRef
    val orders: List<Orders>? = null
)
