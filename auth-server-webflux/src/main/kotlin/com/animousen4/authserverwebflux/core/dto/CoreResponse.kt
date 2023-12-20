package com.animousen4.authserverwebflux.core.dto

import com.animousen4.authserverwebflux.core.validator.ValidationError

open class CoreResponse {
    val errors: List<ValidationError> = emptyList()
}
