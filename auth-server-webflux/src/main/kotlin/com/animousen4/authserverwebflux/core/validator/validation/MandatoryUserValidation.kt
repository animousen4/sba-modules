package com.animousen4.authserverwebflux.core.validator.validation

import com.animousen4.authserverwebflux.core.dto.UserDto
import com.animousen4.authserverwebflux.core.validator.ValidationError
import reactor.core.publisher.Mono

class MandatoryUserValidation : AbstractMandatoryValidation<UserDto> {
    override fun validate(body: Mono<UserDto>): List<ValidationError> {
        TODO("Not yet implemented")
    }
}