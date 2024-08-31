package ru.jwt.main.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties("application")
class ConfigurationProperties @ConstructorBinding constructor(
    val accessSecret: String,
    val refreshSecret: String,
    val accessTokenLifeInMillis: Long,
    val refreshTokenLifeInMillis: Long
)