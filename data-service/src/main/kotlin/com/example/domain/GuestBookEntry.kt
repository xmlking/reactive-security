package com.example.domain

import javax.persistence.*
import javax.validation.constraints.*

import java.time.LocalDateTime;
import javax.persistence.Entity

@Entity
@Table(name = "guest_book")
data class GuestBookEntry(
    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    val name: String,
    val comment: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    val id: Long? = null,
    @Version
    val version: Int? = null,
    @NotNull
    @Column(nullable = false, updatable = false)
    val createdOn: LocalDateTime = LocalDateTime.now(),
    val updatedOn: LocalDateTime?  = null
)
