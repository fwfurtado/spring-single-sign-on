package me.fwfurtad.authorization.configuration

import me.fwfurtad.authorization.login.applications.ClientLoginService
import me.fwfurtad.authorization.login.users.UserLoginService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration(val authenticationManager: AuthenticationManager, val serviceUser: UserLoginService, val clientService: ClientLoginService) : AuthorizationServerConfigurer {

    override fun configure(security: AuthorizationServerSecurityConfigurer?) {
        val security = security ?: throw IllegalArgumentException()

        security
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("permitAll()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        val clients = clients ?: throw IllegalArgumentException()

        clients.withClientDetails(clientService)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        val endpoints = endpoints ?: throw IllegalArgumentException()

        endpoints
                .accessTokenConverter(tokenConverter())
                .tokenStore(tokenStore())
                .userDetailsService(serviceUser)
                .authenticationManager(authenticationManager)
    }

    @Bean
    fun tokenStore(): JwtTokenStore {
        return JwtTokenStore(tokenConverter())
    }

    @Bean
    fun tokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()

        converter.setSigningKey("simetric")

        return converter
    }
}