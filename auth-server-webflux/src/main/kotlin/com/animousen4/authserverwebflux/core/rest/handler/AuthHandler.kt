package com.animousen4.authserverwebflux.core.rest.handler

import com.animousen4.authserverwebflux.core.service.UserService
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class AuthHandler(
    val userService: UserService
) {
    fun createOrUpdateUser(serverRequest: ServerRequest) : Mono<ServerResponse> =
        userService.createOrUpdateUser(serverRequest);

}