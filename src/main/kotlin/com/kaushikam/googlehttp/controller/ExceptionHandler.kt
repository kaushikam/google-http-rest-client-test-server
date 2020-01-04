package com.kaushikam.googlehttp.controller

import com.kaushikam.googlehttp.controller.exception.ResourceNotFoundException
import com.kaushikam.googlehttp.controller.exception.UnProcessableEntityException
import com.kaushikam.googlehttp.facade.ApiError
import com.kaushikam.googlehttp.facade.ApiErrorContainer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(UnProcessableEntityException::class)
    fun handleUnProcessableEntityException(
        e: UnProcessableEntityException,
        r: WebRequest
    ): ResponseEntity<Any> {
        val container = ApiErrorContainer(
            ApiError(e.errorCode.code, e.message)
        )
        return handleExceptionInternal(e, container, HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, r)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        e: ResourceNotFoundException,
        r: WebRequest
    ): ResponseEntity<Any> {
        val container = ApiErrorContainer(
            ApiError(e.errorCode.code, e.message)
        )
        return handleExceptionInternal(e, container, HttpHeaders(), HttpStatus.NOT_FOUND, r)
    }
}