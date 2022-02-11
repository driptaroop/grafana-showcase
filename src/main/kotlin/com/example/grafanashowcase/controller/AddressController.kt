package com.example.grafanashowcase.controller

import com.example.grafanashowcase.faker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/address")
class AddressController{
    @GetMapping("/{id}")
    fun getAddress(@PathVariable id: String): Address = Address()
}

data class Address(
    val street: String = faker.address().streetAddress(),
    val number: String = faker.address().buildingNumber(),
    val zip: String = faker.address().zipCode(),
    val city: String = faker.address().cityName()
)