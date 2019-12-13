package me.fwfurtad.authorization.infra

import me.fwfurtad.authorization.login.applications.ClientLoginRepository
import me.fwfurtad.authorization.shared.Client
import org.springframework.stereotype.Repository

@Repository
class ClientRepository : ClientLoginRepository {

    companion object {
        private val DEFAULT_SECRET = """{bcrypt}${'$'}2a${'$'}10${'$'}FkNyT2N3RUEw4v.sPH2IoemDqvcr.h1RYB9wFLFNdhvColwr/0jWi"""
        private var DATABASE = mutableMapOf<String, Client>()

        init {
            DATABASE["frontend"] = Client("frontend", DEFAULT_SECRET, setOf("read:all"), setOf("password", "refresh_token"))
        }
    }

    override fun findByClientId(clientId: String) = DATABASE[clientId]
}