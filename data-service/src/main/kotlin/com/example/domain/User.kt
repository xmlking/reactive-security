package com.example.domain

import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val login: String,
        @Column(name="firstname")
        val firstname: String,
        val lastname: String,
        val age: Int,
        val email: String,
        val company: String,
        val role: Role = Role.USER,
        val emailHash: String? = null,
        val photoUrl: String? = null
)

enum class Role {
    STAFF,
    USER
}
