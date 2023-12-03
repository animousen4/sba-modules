package com.animousen4.authserverwebflux.core.validator.validation

import com.animousen4.authserverwebflux.core.validator.ValidationError
import reactor.core.publisher.Mono

interface AbstractMandatoryValidation<T> {
    fun validate(body: Mono<T>) : List<ValidationError>
}