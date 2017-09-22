package com.example.web

import org.springframework.http.HttpStatus
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.servlet.http.HttpServletRequest

@CrossOrigin
@RestController
class UserController(val tokenStore: TokenStore) {

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

    // this or revokeToken?
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
