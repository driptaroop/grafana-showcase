package com.example.grafanashowcase.api.model

import com.example.grafanashowcase.address.model.Address
import com.example.grafanashowcase.customerdetails.model.CustomerDetails

data class Customer(
    val details: CustomerDetails,
    val address: Address
)