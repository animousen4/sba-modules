package com.animousen4.authserverwebflux.core.rest.config

import com.animousen4.authserverwebflux.core.rest.handler.AuthHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Service
class RestConfig(
    private val authHandler: AuthHandler
) {
    @Bean
    fun authRouter() = coRouter {
        accept(MediaType.APPLICATION_JSON).nest{
            POST("/user/createOrUpdate", authHandler::createOrUpdateUser)
            GET("/hello-world", accept(TEXT_PLAIN)) {
                ServerResponse.ok().bodyValueAndAwait("Hello World")
            }
        }
    }
}