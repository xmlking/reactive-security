package com.example.repository

import com.example.domain.User
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : PagingAndSortingRepository<User, Long> {
    fun findOneByUsername(username: String): User?
    fun findOneByUsernameIgnoreCase(username: String): User?
    fun findOneByEmail(email: String): User?
}
