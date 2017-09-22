package com.example.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter


@Configuration
@EnableAuthorizationServer
class AuthServerConfig(
    @Value("\${jwt.privateKey}") private val privateKey: String,
    @Value("\${jwt.publicKey}") private val publicKey: String,
    @Value("\${jwt.accessTokenTimeout:1800}") private val accessTokenTimeout: Int,
    @Value("\${jwt.refreshTokenTimeout:3600}") private val refreshTokenTimeout: Int,
    @Qualifier("userDetailsService") private val userDetailsService: UserDetailsService
//    private val authenticationManager: AuthenticationManager // cycle dependency
) : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    //NODE : We need to add this....https://gitter.im/spring-projects/spring-security/archives/2017/06/07
    @Bean
    @Primary
    @Throws(Exception::class)
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager {
        return configuration.authenticationManager
    }

    @Bean
    fun tokenStore(): TokenStore {
        return InMemoryTokenStore()
    }

    @Bean
    @Throws(Exception::class)
    fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey(privateKey)
        converter.setVerifierKey(publicKey)
        return converter
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
            .tokenStore(tokenStore()).reuseRefreshTokens(false)
            .tokenEnhancer(jwtAccessTokenConverter())
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService)
    }

    @Throws(Exception::class)
    override fun configure(oauthServer: AuthorizationServerSecurityConfigurer) {
        oauthServer
            .tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_CLIENT')")
            .checkTokenAccess("hasAuthority('ROLE_CLIENT')")
            .allowFormAuthenticationForClients()
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
            .withClient("my-trusted-client")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("read", "write", "trust")
            .autoApprove(true)
            .accessTokenValiditySeconds(600)
            .refreshTokenValiditySeconds(1600)
            .and()
            .withClient("my-client-with-registered-redirect")
            .authorizedGrantTypes("authorization_code")
            .authorities("ROLE_CLIENT")
            .scopes("read", "trust")
            .autoApprove(true)
            .redirectUris("http://anywhere?key=value")
            .and()
            .withClient("my-client-with-secret")
            .authorizedGrantTypes("client_credentials", "password")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("read", "write")
            .secret("secret")
    }

}
