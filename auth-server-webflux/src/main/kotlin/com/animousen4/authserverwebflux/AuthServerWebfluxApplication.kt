package com.animousen4.authserverwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories
@SpringBootApplication
class AuthServerWebfluxApplication

fun main(args: Array<String>) {
	runApplication<AuthServerWebfluxApplication>(*args)
}
