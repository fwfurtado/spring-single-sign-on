package me.fwfurtad.authorization.login.users

import me.fwfurtad.authorization.shared.User

interface UserLoginRepository {
    fun findByUsername(username: String) : User?
}
