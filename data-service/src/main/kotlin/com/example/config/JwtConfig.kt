package com.example.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
class JwtConfig(@Value("\${jwt.publicKey}") private val publicKey: String) {

    @Autowired
    private val jwtAccessTokenConverter: JwtAccessTokenConverter? = null


    @Bean
    @Qualifier("tokenStore")
    fun tokenStore(): TokenStore {
        return JwtTokenStore(jwtAccessTokenConverter)
    }

    @Bean
    protected fun jwtTokenEnhancer(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setVerifierKey(publicKey)
        return converter
    }

}


