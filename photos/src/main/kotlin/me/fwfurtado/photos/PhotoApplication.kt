package me.fwfurtado.photos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PhotoApplication

fun main(args: Array<String>) {
    runApplication<PhotoApplication>(*args)
}