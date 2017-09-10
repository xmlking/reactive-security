package com.example.domain

import javax.persistence.*;

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long
)
