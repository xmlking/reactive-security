//package com.example.config
//
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.http.SessionCreationPolicy
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
//import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler
//import org.springframework.security.oauth2.provider.token.TokenStore
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
//
//
//@Configuration
//@EnableResourceServer
//class OAuth2ResourceServerConfig1(@Value("\${jwt.publicKey}") private val publicKey: String) : ResourceServerConfigurerAdapter() {
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//            .cors().and().csrf().disable()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeRequests().antMatchers("/**").authenticated()
//    }
//
//    @Bean
//    @Qualifier("tokenStore")
//    fun tokenStore(): TokenStore {
//        return JwtTokenStore(jwtTokenEnhancer())
//    }
//
//    @Bean
//    protected fun jwtTokenEnhancer(): JwtAccessTokenConverter {
//        val converter = JwtAccessTokenConverter()
//        converter.setVerifierKey(publicKey)
//        return converter
//    }
//
//}
//
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class MethodSecurityConfig : GlobalMethodSecurityConfiguration() {
//
//    override fun createExpressionHandler(): MethodSecurityExpressionHandler {
//        return OAuth2MethodSecurityExpressionHandler()
//    }
//
//}
