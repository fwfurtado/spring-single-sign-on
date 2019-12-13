package me.fwfurtad.authorization.login.applications

import me.fwfurtad.authorization.shared.Client
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class ClientToClientApplicationConverter {
    fun convert(client: Client) : ClientApplication {
        return ClientApplication(client.clientId, client.clientSecret, client.grantTypes, client.scopes, Duration.ofSeconds(90), Duration.ofSeconds(600))
    }
}
