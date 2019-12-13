package me.fwfurtad.authorization.login.users

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserLoginService(val repository: UserLoginRepository, val toResourceOwnerConverter: UserToResourceOwnerConverter) : UserDetailsService {
    override fun loadUserByUsername(login: String?): UserDetails {
        val username = login ?: throw UsernameNotFoundException("Username required.")

        return repository.findByUsername(username)?.let(toResourceOwnerConverter::convert) ?: throw UsernameNotFoundException(username)
    }
}