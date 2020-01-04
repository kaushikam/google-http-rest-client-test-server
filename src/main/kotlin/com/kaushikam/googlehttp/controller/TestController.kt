package com.kaushikam.googlehttp.controller

import com.kaushikam.googlehttp.controller.exception.ConsumerNotFoundException
import com.kaushikam.googlehttp.facade.ConsumerId
import com.kaushikam.googlehttp.facade.RestRequest
import com.kaushikam.googlehttp.facade.RestResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @PostMapping("/v1/hello", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloWorld(
        @RequestBody request: RestRequest
    ): ResponseEntity<RestResponse> {
        println("Request: $request")
        if (request.consumerId._id == "1234567890")
            throw ConsumerNotFoundException(consumerId = "1234567890")

        return ResponseEntity(RestResponse(message = "Hello ${request.consumerId._id}"), HttpStatus.OK)
    }
}