package com.example.web

import org.springframework.http.HttpStatus
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/")
@CrossOrigin
class TokenRestController(val tokenStore: TokenStore) {

    @GetMapping(value = "/oauth/revoke-token")
    @ResponseStatus(HttpStatus.OK)
    fun logout(request: HttpServletRequest) {
        val authHeader = request.getHeader("Authorization")
        if (authHeader != null) {
            val tokenValue = authHeader.replace("Bearer", "").trim()
            val accessToken = tokenStore.readAccessToken(tokenValue)
            tokenStore.removeAccessToken(accessToken)
        }
    }
}
