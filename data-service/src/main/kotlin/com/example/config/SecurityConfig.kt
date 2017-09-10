package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod.DELETE
import org.springframework.http.HttpMethod.GET
import org.springframework.security.authorization.AuthorizationDecision
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.HttpSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.MapUserDetailsRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authorization.AuthorizationContext
import org.springframework.security.web.server.util.matcher.PathMatcherServerWebExchangeMatcher
import reactor.core.publisher.Mono


@EnableWebFluxSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig  /*: WebSecurityConfigurerAdapter */ {

    @Bean
    fun springWebFilterChain(http: HttpSecurity): SecurityWebFilterChain {
        return http
            .securityMatcher( PathMatcherServerWebExchangeMatcher("/api/**"))
            .authorizeExchange()
            .pathMatchers(GET, "/posts/**").permitAll()
            .pathMatchers(DELETE, "/posts/**").hasRole("ADMIN")
            .pathMatchers("/*/users/admin/**").hasRole("ADMIN")
            .pathMatchers("/*/users/{user}/**").access(this::currentUserMatchesPath)
            .anyExchange().authenticated()
            .and()
            .build()
    }

    private fun currentUserMatchesPath(authentication: Mono<Authentication>, context: AuthorizationContext): Mono<AuthorizationDecision> {
        return authentication
                .map { a -> context.variables["user"] == a.name }
                .map { granted -> AuthorizationDecision(granted) }
    }

    @Bean
    fun userDetailsRepository(): MapUserDetailsRepository {
        val rob = User.withUsername("rob").password("rob").roles("USER").build()
        val admin = User.withUsername("admin").password("admin").roles("USER", "ADMIN").build()
        return MapUserDetailsRepository(rob, admin)
    }

}
