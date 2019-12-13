package me.fwfurtad.authorization.shared

data class User(val username: String, val password: String, val roles: Array<String>, val status: UserStatus)