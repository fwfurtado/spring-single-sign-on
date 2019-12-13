package me.fwfurtad.authorization.login.users

import me.fwfurtad.authorization.shared.User
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

class ResourceOwner(val user: User) : UserDetails{
    override fun getAuthorities() = AuthorityUtils.createAuthorityList(*user.roles)
    override fun getUsername()  = user.username
    override fun getPassword() = user.password
    override fun isEnabled() = user.status.canDoLogin()
    override fun isCredentialsNonExpired() = true
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true

}
