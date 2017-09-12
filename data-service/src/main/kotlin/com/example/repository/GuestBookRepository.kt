package com.example.repository

import com.example.domain.GuestBookEntry
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestBookRepository : PagingAndSortingRepository<GuestBookEntry, Long> {
}
