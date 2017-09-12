package com.example.web

import com.example.domain.GuestBookEntry
import com.example.repository.GuestBookRepository
import org.springframework.security.core.Authentication
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal


@RestController
@RequestMapping("/api/guestbook")
class GuestBookController(val repository: GuestBookRepository) {

    @GetMapping("")
    fun index() = repository.findAll()

    @PostMapping("")
    fun create(@RequestBody guestBookEntry: GuestBookEntry) = this.repository.save(guestBookEntry)

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = this.repository.findById(id)
}
