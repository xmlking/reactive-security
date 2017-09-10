package com.example.repository

import com.example.domain.GuestBookEntry
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@Repository
public interface GuestBookRepository : ReactiveSortingRepository<GuestBookEntry, Long> {

    fun findByName(name: String): Flux<GuestBookEntry>
    fun findByNameAndTime(name: String, time: LocalDateTime): Flux<GuestBookEntry>

    fun findByNameAndTimeAfter(name: String, time: LocalDateTime): Flux<GuestBookEntry>
}
