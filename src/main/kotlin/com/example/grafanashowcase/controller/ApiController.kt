package com.example.grafanashowcase.controller

import com.example.grafanashowcase.client.AddressClient
import com.example.grafanashowcase.client.CustomerDetailsClient
import com.example.grafanashowcase.model.Customer
import io.micrometer.core.annotation.Timed
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
@Timed("customers")
class ApiController(
    private val addressClient: AddressClient,
    private val customerDetailsClient: CustomerDetailsClient
) {
    private val log = LoggerFactory.getLogger(this::class.java)
    @GetMapping("/{id}")
    fun customer(@PathVariable id: String): Customer {
        log.info("fetching customer with id: $id")
        return Customer(customerDetailsClient.getDetails(id), addressClient.getAddress(id))
    }
}

