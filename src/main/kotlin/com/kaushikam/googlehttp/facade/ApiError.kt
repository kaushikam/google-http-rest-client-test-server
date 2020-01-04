package com.kaushikam.googlehttp.facade

data class ApiError (
    val errorCode: Int,
    val message: String
)

data class ApiErrorContainer (
    val error: ApiError
)