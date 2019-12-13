package me.fwfurtad.authorization.login.applications

import me.fwfurtad.authorization.shared.Client

interface ClientLoginRepository {
    fun findByClientId(clientId: String): Client?
}