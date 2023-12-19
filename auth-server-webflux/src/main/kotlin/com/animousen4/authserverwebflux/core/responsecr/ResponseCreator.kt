package com.animousen4.authserverwebflux.core.responsecr

import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

class ResponseCreator {
    companion object {
        fun <V, E> createServerResponse(body: Mono<V>, cl: Class<V>): ServerResponse {

        }
    }
}