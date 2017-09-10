package com.example.repository

import com.example.domain.Role
import reactor.core.publisher.Mono
import com.example.domain.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface UserRepository : ReactiveSortingRepository<User, Long> {

    fun findByLogin(login: String): Flux<User>
    @Query("{ 'login': ?0 and 'email' : ?1 }")
    fun findByLoginAndEmail(login: String, email: String): Mono<User>
    fun findByLoginAndRoleAndCompany(login: String, role: Role, company: String): Mono<User>
    @Query("{ 'role': ?0 and 'company' : ?1 }")
    fun findAllByRole(role: Role, company: String = "Microsoft" ): Flux<User>
    @Query("SELECT * from user WHERE company = ?0")
    fun findAllByCompany(company: String): Flux<User>
}
