package com.example.grafanashowcase.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class ApiController {
    private val log = LoggerFactory.getLogger(this::class.java)
    @GetMapping("/{id}")
    fun customer(@PathVariable id: String): Customer {
        log.info("fetching customer with id: $id")
        return Customer("Dripto", 21)
    }
}

data class Customer(
    val name: String,
    val age: Int
)