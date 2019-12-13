package me.fwfurtado.mail.inbox

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InboxController {

    @GetMapping("inbox")
    fun inbox(): ResponseEntity<Void> {
        return ok().build()
    }
}