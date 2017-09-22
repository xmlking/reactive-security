package com.example.domain

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Cacheable
@Table(name = "roles")
class Role(
    @Column(name = "name", nullable = false, unique = true)
    private val name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : GrantedAuthority {

    companion object {
        val ROLE_USER =  "ROLE_USER"
        val ROLE_ADMIN= "ROLE_ADMIN"
        val ROLE_ACTUATOR =  "ROLE_ACTUATOR"
    }

    override fun getAuthority(): String {
        return name
    }
}
