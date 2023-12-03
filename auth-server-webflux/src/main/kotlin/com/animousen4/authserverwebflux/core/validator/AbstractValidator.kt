package com.animousen4.authserverwebflux.core.validator

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class AbstractValidator<T> {
    abstract fun validate(body: Mono<T>): Flux<ValidationError>
}