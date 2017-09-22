package com.example.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import com.example.domain.User


@Service
public class SpringSecurityService(val passwordEncoder: PasswordEncoder) {
    fun encodePassword(password: String, salt: String? = null): String {
        return passwordEncoder.encode(password)
    }

    fun emailExists(email: String): Boolean {
        return true// createQuery().filter("email", email).countAll() > 0
    }

    fun renewPassword(user: User, oldPassword: String, newPassword: String) {
        // TODO
    }

    fun isPasswordValid(user: User, rawPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, user.password)
    }
    fun lock(username: String) {
        // TODO
    }

    fun unlock(username: String) {
        // TODO
    }
}
