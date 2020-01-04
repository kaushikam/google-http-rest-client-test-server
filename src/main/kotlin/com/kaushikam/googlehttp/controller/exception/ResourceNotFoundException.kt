package com.kaushikam.googlehttp.controller.exception

abstract class ResourceNotFoundException (
    override val errorCode: ErrorCode,
    override val message: String,
    override val cause: Throwable?,
    override val args: Array<Any>
): BaseException(errorCode, message, cause, args)