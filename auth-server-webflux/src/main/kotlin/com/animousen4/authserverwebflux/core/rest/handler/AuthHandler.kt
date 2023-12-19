package com.animousen4.authserverwebflux.core.rest.handler

import com.animousen4.authserverwebflux.core.service.UserService
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

@Service
class AuthHandler(
    val userService: UserService
) {
    suspend fun createOrUpdateUser(serverRequest: ServerRequest) : ServerResponse {
        return ServerResponse.ok().buildAndAwait()
    }

    suspend fun getUserInfo(serverRequest: ServerRequest) : ServerResponse {
        return userService.getUserInfo(serverRequest);
    }

}