package com.example.repository

import com.example.domain.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : CrudRepository<Role, Long> {
    fun findOneByName(role: String): Role?
}
