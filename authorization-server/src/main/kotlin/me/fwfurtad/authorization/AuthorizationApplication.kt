package me.fwfurtad.authorization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.factory.PasswordEncoderFactories

@SpringBootApplication
class AuthorizationApplication

fun main(args: Array<String>) {
    runApplication<AuthorizationApplication>(*args)
}