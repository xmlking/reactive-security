package com.example.web

import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
class UserController(val tokenStore: InMemoryTokenStore) {

    @GetMapping("/principal")
    fun user(user: Principal): Principal {
        return user
    }

    @RequestMapping("/userinfo")
    fun userinfo(principal: Principal): String {
        return principal.name
    }

    @PostMapping("/revoke")
    fun revokeToken(@RequestParam("refresh_token") refreshToken: String): String {
        val oauthRefreshToken = tokenStore.readRefreshToken(refreshToken)
        if (oauthRefreshToken != null) {
            tokenStore.removeAccessTokenUsingRefreshToken(oauthRefreshToken)
            tokenStore.removeRefreshToken(oauthRefreshToken)
            return "OK, refresh token was removed"
        } else {
            return "OK, refresh token does not exist"
        }
    }
}
