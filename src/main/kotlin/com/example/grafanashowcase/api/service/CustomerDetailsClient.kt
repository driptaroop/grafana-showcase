package com.example.grafanashowcase.api.service

import com.example.grafanashowcase.customerdetails.model.CustomerDetails
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class CustomerDetailsClient(private val restTemplate: RestTemplate) {
    fun getDetails(id: String): CustomerDetails? = restTemplate.getForObject("http://customer-details-service:8080/customer-details/$id")
}