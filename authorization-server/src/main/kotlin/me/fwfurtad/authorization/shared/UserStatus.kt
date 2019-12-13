package me.fwfurtad.authorization.shared

enum class UserStatus {
    ACTIVE, INACTIVE;

    fun canDoLogin() = this == ACTIVE
}