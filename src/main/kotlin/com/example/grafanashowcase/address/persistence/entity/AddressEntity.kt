package com.example.grafanashowcase.address.persistence.entity

import com.example.grafanashowcase.address.model.Address
import com.example.grafanashowcase.util.faker
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class AddressEntity(
    @Id val id: Long,
    val street: String = faker.address().streetAddress(),
    val number: String = faker.address().buildingNumber(),
    val zip: String = faker.address().zipCode(),
    val city: String = faker.address().cityName()
){
    val model: Address
        get() = Address(street = street, number = number, zip = zip, city = city)
}

