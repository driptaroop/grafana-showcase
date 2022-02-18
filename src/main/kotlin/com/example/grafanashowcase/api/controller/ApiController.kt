package com.example.grafanashowcase.api.controller

import com.example.grafanashowcase.api.service.AddressClient
import com.example.grafanashowcase.api.service.CustomerDetailsClient
import com.example.grafanashowcase.api.model.Customer
import io.micrometer.core.annotation.Timed
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
@Timed("api")
class ApiController(
    private val addressClient: AddressClient,
    private val customerDetailsClient: CustomerDetailsClient
) {
    private val log = LoggerFactory.getLogger(this::class.java)
    @GetMapping("/{id}")
    fun customer(@PathVariable id: String, @RequestHeader headers: Map<String, String>): Customer {
        log.info("fetching customer with id: $id")
        log.info("request header: $headers")
        log.info("mdc: ${MDC.getCopyOfContextMap()}")
        val details = customerDetailsClient.getDetails(id)
        val address = addressClient.getAddress(id)
        return if(details != null && address != null) Customer(details, address) else throw IllegalStateException("no such customer")
    }
}

