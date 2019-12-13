package me.fwfurtad.authorization.login.applications

import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.security.oauth2.provider.ClientRegistrationException
import org.springframework.stereotype.Service

@Service
class ClientLoginService(val repository: ClientLoginRepository, val toClientApplicationConverter: ClientToClientApplicationConverter) : ClientDetailsService {

    override fun loadClientByClientId(login: String?): ClientDetails {
        val clientId = login ?: throw ClientRegistrationException("ClientId required.")

        return repository.findByClientId(clientId)?.let(toClientApplicationConverter::convert) ?: throw ClientRegistrationException("Cannot find client with ${clientId}")
    }
}