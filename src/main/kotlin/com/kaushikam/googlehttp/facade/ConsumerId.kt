package com.kaushikam.googlehttp.facade

import com.kaushikam.googlehttp.controller.exception.ErrorCode
import com.kaushikam.googlehttp.controller.exception.UnProcessableEntityException
import java.util.regex.Pattern

class ConsumerId (
    val _id: String
) {
    init {
        if (!Pattern.matches("^[1-9]\\d{9}$", _id))
            throw ConsumerIdFormatException(consumerId = _id)
    }

    override fun toString(): String {
        return this._id;
    }
}

class ConsumerIdFormatException (
    override val errorCode: ErrorCode = ErrorCode.CONSUMER_ID_FORMAT_EXCEPTION,
    val consumerId: String
): UnProcessableEntityException(errorCode, "Consumer id $consumerId is not valid", null, arrayOf(consumerId))