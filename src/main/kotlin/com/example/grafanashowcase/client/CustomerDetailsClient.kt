package com.example.grafanashowcase.client

import com.example.grafanashowcase.controller.CustomerDetails
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class CustomerDetailsClient(private val restTemplate: RestTemplate) {
    fun getDetails(id: String): CustomerDetails = restTemplate.getForObject("http://customer-details-service:8080/customer-details/$id")
}