package com.example.grafanashowcase.controller

import com.example.grafanashowcase.faker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("/customer-details")
class CustomerController {
    @GetMapping("/{id}")
    fun getDetails(@PathVariable id: String): CustomerDetails = CustomerDetails()
}

data class CustomerDetails(
    val name: String = faker.name().fullName(),
    val age: Int = Random.nextInt(1, 100)
)