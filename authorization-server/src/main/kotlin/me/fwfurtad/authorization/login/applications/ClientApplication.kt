package me.fwfurtad.authorization.login.applications

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.provider.ClientDetails
import java.time.Duration
import java.time.LocalDate

class ClientApplication(private val clientId: String, private val secret: String,
                        private val grantTypes: Set<String>, private val scopes: Set<String>,
                        private val tokenExpiration: Duration,
                        private val refreshTokenExpiration: Duration) : ClientDetails {


    override fun isSecretRequired() = true

    override fun getClientId() = clientId

    override fun isAutoApprove(scope: String?) = false

    override fun getAdditionalInformation() = mapOf<String, Any>("some_information" to LocalDate.now(), "other_information" to "information", "other_v2" to 123)

    override fun getAccessTokenValiditySeconds() = tokenExpiration.seconds.toInt()

    override fun getRefreshTokenValiditySeconds() = refreshTokenExpiration.seconds.toInt()

    override fun getResourceIds() = setOf<String>("mail")

    override fun getAuthorities() = setOf<GrantedAuthority>()

    override fun getClientSecret() = secret

    override fun getRegisteredRedirectUri() = setOf<String>()

    override fun isScoped() = true

    override fun getScope() = scopes

    override fun getAuthorizedGrantTypes() = grantTypes
}