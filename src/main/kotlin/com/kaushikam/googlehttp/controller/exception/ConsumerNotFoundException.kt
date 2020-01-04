package com.kaushikam.googlehttp.controller.exception

class ConsumerNotFoundException (
    override val errorCode: ErrorCode = ErrorCode.CONSUMER_NOT_FOUND_EXCEPTION,
    val consumerId: String
): ResourceNotFoundException(errorCode, "There is no consumer with consumer id $consumerId", null, arrayOf(consumerId))