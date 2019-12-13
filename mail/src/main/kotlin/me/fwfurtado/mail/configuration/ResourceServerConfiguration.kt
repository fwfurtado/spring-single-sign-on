package me.fwfurtado.mail.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import java.lang.IllegalArgumentException

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurer {
    override fun configure(resources: ResourceServerSecurityConfigurer?) {
        val resources = resources ?: throw IllegalArgumentException()

        resources.resourceId("mail")
    }

    override fun configure(http: HttpSecurity?) {
        val http = http ?: throw IllegalArgumentException()

        http.authorizeRequests()
                .antMatchers("/inbox/**").access("#oauth2.hasScope('read:all') and hasRole('USER')")
    }
}