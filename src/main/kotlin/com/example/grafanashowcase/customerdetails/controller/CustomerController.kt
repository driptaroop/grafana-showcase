package com.example.grafanashowcase.customerdetails.controller

import com.example.grafanashowcase.customerdetails.model.CustomerDetails
import com.example.grafanashowcase.customerdetails.persistence.dao.CustomerDetailsRepo
import io.micrometer.core.annotation.Timed
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer-details")
@Timed("customer-details")
class CustomerController(private val repo: CustomerDetailsRepo) {
    @GetMapping("/{id}")
    fun getDetails(@PathVariable id: Long): CustomerDetails? = repo.findByIdOrNull(id)?.model
}

