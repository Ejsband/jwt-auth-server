package ru.jwt.main

import io.jsonwebtoken.JwsHeader
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import org.springframework.stereotype.Service
import ru.jwt.main.configuration.ConfigurationProperties

@Service
class JwtService(
    private val properties: ConfigurationProperties
) {

    private val accessSecretKey = Keys.hmacShaKeyFor(properties.accessSecret.toByteArray())
    private val refreshSecretKey = Keys.hmacShaKeyFor(properties.refreshSecret.toByteArray())
    private val accessTokenLifeInMillis = properties.accessTokenLifeInMillis
    private val refreshTokenLifeInMillis = properties.refreshTokenLifeInMillis


    fun generateToken(): String {

        val timeStamp = localDateTimeToEpochMilli(LocalDateTime.now())

        return Jwts.builder()
            .header().type("JWT")
            .and()
            .issuer("Ilya Bogdanov")
            .subject("email")
            .issuedAt(Date.from(Instant.now()))
            .expiration(Date(timeStamp + accessTokenLifeInMillis))
            .signWith(accessSecretKey, Jwts.SIG.HS512)
            .compact()
    }


//fun decode(token: String, key: SecretKey): TokenClaims {
//    try {
//        val jws = Jwts.parser()
//            .verifyWith(key)
//            .build()
//            .parseSignedClaims(token)
//            .payload
//        return TokenClaims(jws.issuer, jws.subject, jws["role"].toString(), jws.issuedAt, jws.expiration)
//
//    } catch (e: JwtException) {
//        when (e) {
//            is ExpiredJwtException -> {
//                throw TokenExpiredException()
//            }
//        }
//        throw InvalidTokenException()
//    } catch (e: IllegalArgumentException) {
//        throw InvalidTokenException()
//    }
//}


    fun decode(token: String): JwsHeader {

        return Jwts.parser()

            .clockSkewSeconds(60)

            .verifyWith(accessSecretKey)
            .requireSubject("email")

            .build()
            .parseSignedClaims(token)
            .header

    }

    private fun localDateTimeToEpochMilli(localDateTime: LocalDateTime): Long {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
    }
}
