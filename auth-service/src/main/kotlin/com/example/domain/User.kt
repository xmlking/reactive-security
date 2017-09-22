package com.example.domain

import org.hibernate.annotations.DynamicUpdate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Size
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity()
@Table(name = "users" )
@DynamicUpdate(true)
@EntityListeners(AuditingEntityListener::class)
data class User (

        @Size(min = 5, max = 100)
        @Column(name = "username", length = 100, nullable = false, unique = true)
        private val username: String,
        @Size(min = 5, max = 100)
        @Column(name = "password", length = 100, nullable = false)
        @JsonIgnore
        private var password: String,

        @Column(length = 100, nullable = false, unique = true)
        var email: String,

        @Column(nullable = false)
        var firstName: String,
        @Column(nullable = false)
        var lastName: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_role",
            joinColumns = arrayOf(JoinColumn(name = "user_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
        var roles: Set<Role> = mutableSetOf(),

        var company: String = "",
        var photoUrl: String = "",

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, updatable = false)
        val id: Long = 0,

        @Column(nullable = false)
        var enabled: Boolean = true,
        var accountExpired: Boolean = false,
        var accountLocked: Boolean = false,
        var passwordExpired: Boolean = false,

        @CreatedDate
        @Column(nullable = false, updatable = false)
        var createDate: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate
        @Column(nullable = false)
        var updateDate: LocalDateTime = LocalDateTime.now() //LocalDateTime.MIN,

//        @Autowired @Transient var passwordEncoder: PasswordEncoder? = null
) : UserDetails {

    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }

    fun setPassword(_password: String) {
        password = _password
        encodePassword()
    }

    override fun getAuthorities(): Collection<GrantedAuthority>? {
        return this.roles
    }

    @PrePersist
    fun beforeInsert() {
        encodePassword()
    }

    @PreUpdate
    fun beforeUpdate() {
        updateDate = LocalDateTime.now()
        // encodePassword()
    }

    private fun encodePassword() {
         val encoder = BCryptPasswordEncoder()
         password = encoder.encode(this.password)
    }

    override fun isAccountNonExpired() = !accountExpired

    override fun isAccountNonLocked() = !accountLocked

    override fun isCredentialsNonExpired() = !passwordExpired

    override fun isEnabled() = enabled
}
