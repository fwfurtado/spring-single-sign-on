package me.fwfurtad.authorization.infra

import me.fwfurtad.authorization.login.users.UserLoginRepository
import me.fwfurtad.authorization.shared.User
import me.fwfurtad.authorization.shared.UserStatus
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryUser : UserLoginRepository {
    companion object {
        private val DEFAULT_PASSWORD = """{bcrypt}${'$'}2a${'$'}10${'$'}OhWTNpUaFqzRh6uSW1fjPeG0lJaT5eI2o.wUXCxC1tMDf9dH5dpIe"""
        private var DATABASE = mutableMapOf<String, User>()

        init {
            DATABASE["fwfurtado"] = User("fwfurtado", DEFAULT_PASSWORD, arrayOf("ROLE_USER"), UserStatus.ACTIVE)
        }
    }

    override fun findByUsername(username: String) = DATABASE.get(username)
}