package com.animousen4.authserverwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthServerWebfluxApplication

fun main(args: Array<String>) {
	runApplication<AuthServerWebfluxApplication>(*args)
}
