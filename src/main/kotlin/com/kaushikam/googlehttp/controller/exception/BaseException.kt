package com.kaushikam.googlehttp.controller.exception

import java.lang.RuntimeException

abstract class BaseException (
    open val errorCode: ErrorCode,
    override val message: String,
    override val cause: Throwable?,
    open val args: Array<Any>
): RuntimeException(message, cause)

enum class ErrorCode (
    val code: Int
) {
    CONSUMER_ID_FORMAT_EXCEPTION(0),
    CONSUMER_NOT_FOUND_EXCEPTION(1)
}