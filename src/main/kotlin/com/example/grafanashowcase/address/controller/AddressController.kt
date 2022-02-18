package com.example.grafanashowcase.address.controller

import com.example.grafanashowcase.address.model.Address
import com.example.grafanashowcase.address.persistence.dao.AddressRepo
import io.micrometer.core.annotation.Timed
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/address")
@Timed("address")
class AddressController(private val repo: AddressRepo){
    @GetMapping("/{id}")
    fun getAddress(@PathVariable id: Long): Address? = repo.findByIdOrNull(id)?.model
}

