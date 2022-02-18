package com.example.grafanashowcase.customerdetails.persistence.entity

import com.example.grafanashowcase.customerdetails.model.CustomerDetails
import com.example.grafanashowcase.util.faker
import javax.persistence.Entity
import javax.persistence.Id
import kotlin.random.Random

@Entity
data class CustomerDetailsEntity(
    @Id val id: Long,
    val name: String = faker.name().fullName(),
    val age: Int = Random.nextInt(1, 100)
){
    val model: CustomerDetails
        get() = CustomerDetails(name = name, age = age)
}