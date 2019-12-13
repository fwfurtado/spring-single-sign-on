package me.fwfurtad.authorization.login.users

import me.fwfurtad.authorization.shared.User
import org.springframework.stereotype.Component

@Component
class UserToResourceOwnerConverter {

    fun convert(user: User) = ResourceOwner(user)
}
