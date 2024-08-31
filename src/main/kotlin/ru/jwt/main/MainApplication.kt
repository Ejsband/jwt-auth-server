package ru.jwt.main

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)


//	val token: String = generateToken()
//	println("------------------------TOKEN----------------------------------------------------")
//	println(token)
//	println()
//	println("------------------------CLAIMS----------------------------------------------------")
//	println(decode(token))


//	//code to test parsed token : Claims
//	val claims: Claims = Jwts.parser()
//		.setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
//		.parseClaimsJws(token)
//		.getBody()
//
//	println("Token ID: " + claims.id)
//	println("Token Subject: " + claims.subject)
//	println("Token Issuer: " + claims.issuer)
//	println("Token Issue Date: " + claims.issuedAt)
//	println("Token Expiration Date: " + claims.expiration)
//	println("Token Audience: " + claims.audience)
}
