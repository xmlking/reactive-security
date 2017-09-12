package com.example.domain

import javax.persistence.*;

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    val name: String
)
