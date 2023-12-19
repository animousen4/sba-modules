package com.animousen4.authserverwebflux.core.dto

import com.animousen4.authserverwebflux.core.enums.FieldEnum

data class ErrorInfo(val error: Error, val field: FieldEnum, val errorMsg: String) {

    companion object {
        fun create(error: Error, field: FieldEnum, errorMsg: String): ErrorInfo = ErrorInfo(error, field, errorMsg)
        fun create(error: Error, errorMsg: String): ErrorInfo = ErrorInfo(error, FieldEnum.GENERAL_FIELD, errorMsg)

        @Deprecated(" use 'responseBody.errors.whenNoErrors' expression ")
        val noErrors = MutableCollection<ErrorInfo>::isEmpty
        val noCollectionsErrors = Collection<ErrorInfo>::isEmpty
    }
}