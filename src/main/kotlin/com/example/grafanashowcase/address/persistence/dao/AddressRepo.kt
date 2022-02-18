package com.example.grafanashowcase.address.persistence.dao

import com.example.grafanashowcase.address.persistence.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface AddressRepo: JpaRepository<AddressEntity, Long>

@Component
class AddressInitializer(private val addressRepo: AddressRepo){
    fun init(n: Int){
        (1..n).map { AddressEntity(id = it.toLong()) }.let { addressRepo.saveAll(it) }
    }
}