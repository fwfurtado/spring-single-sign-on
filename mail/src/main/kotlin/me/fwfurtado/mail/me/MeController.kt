package me.fwfurtado.mail.me

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class MeController {

    @GetMapping("users/me")
    fun me(principal: Principal) : Principal {
        return principal
    }
}