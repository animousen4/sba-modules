package com.animousen4.authserverwebflux.core.rest.config

import com.animousen4.authserverwebflux.core.rest.handler.AuthHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router

@Service
class RestConfig(
    private val authHandler: AuthHandler
) {
    @Bean
    fun authRouter() = coRouter {

        accept(
            APPLICATION_JSON
        ).and(path("/api")).nest {
            GET("/getUser", authHandler::getUserInfo)
        }
    }
}