package com.example.practice.demo.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.http.HttpStatus


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class UserResponse(
     val message: String? = null,
     @DBRef
     val data: UserModel? = null,
     val status: HttpStatus? = null
)
