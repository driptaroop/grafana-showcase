package com.example.grafanashowcase.customerdetails.persistence.dao

import com.example.grafanashowcase.customerdetails.persistence.entity.CustomerDetailsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface CustomerDetailsRepo: JpaRepository<CustomerDetailsEntity, Long>

@Component
class CustomerDetailsInitiator(private val repo: CustomerDetailsRepo){
    fun init(n: Int){
        (1..n).map { CustomerDetailsEntity(id = it.toLong()) }.let{ repo.saveAll(it) }
    }
}