package com.example.grafanashowcase.api.service

import com.example.grafanashowcase.address.model.Address
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class AddressClient(private val restTemplate: RestTemplate) {
    fun getAddress(id: String): Address? = restTemplate.getForObject("http://address-service:8080/address/$id")
}

