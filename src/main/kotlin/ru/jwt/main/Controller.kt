package ru.jwt.main

import io.jsonwebtoken.JwsHeader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val jwtService: JwtService,
) {

    @GetMapping("/")
    fun getToken(): String {
        return jwtService.generateToken()
    }

    @GetMapping("/check")
    fun checkToken(@RequestParam token: String): JwsHeader {
        return jwtService.decode(token)
    }
}