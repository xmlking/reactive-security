package com.example.web

import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
class UserController() {

    @GetMapping("/userinfo")
    fun userinfo(authentication: Authentication): String {
        val username = authentication.name
        val roles = StringUtils.collectionToDelimitedString(authentication.authorities, ", ")
        return username + ": " + roles
    }

    @GetMapping("/principal")
    fun user(user: Principal): Principal {
        return user
    }

}
