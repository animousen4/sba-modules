package com.animousen4.authserverwebflux.core.validator

import com.animousen4.authserverwebflux.core.dto.CreateOrUpdateUserRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CreateOrUpdateValidator : AbstractValidator<CreateOrUpdateUserRequest>() {
    override fun validate(body: Mono<CreateOrUpdateUserRequest>): Flux<ValidationError> {
        return Flux.empty()
    }
}