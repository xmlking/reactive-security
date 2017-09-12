package com.example.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter

@Configuration
@EnableAuthorizationServer
class AuthServerConfig(
        @Value("\${jwt.privateKey}") private val privateKey: String,
        @Value("\${jwt.publicKey}") private val publicKey: String,
        private val authenticationManager: AuthenticationManager
) : AuthorizationServerConfigurerAdapter() {

    @Bean
    protected fun tokenStore(): InMemoryTokenStore {
        return InMemoryTokenStore()
    }

    @Bean
    protected fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey(privateKey)
        converter.setVerifierKey(publicKey)
        return converter
    }


    @Override
    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
                .tokenStore(tokenStore()).reuseRefreshTokens(false)
                .tokenEnhancer(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager) // CustomUserDetailsService ???
        //https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html
        //https://stackoverflow.com/questions/26208087/spring-boot-oauth-2-0-userdetails-user-not-found
        //https://github.com/rajithd/spring-boot-oauth2/blob/master/src/main/java/com/rd/domain/User.java
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
