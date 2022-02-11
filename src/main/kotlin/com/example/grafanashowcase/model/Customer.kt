package com.example.grafanashowcase.model

import com.example.grafanashowcase.controller.Address
import com.example.grafanashowcase.controller.CustomerDetails

data class Customer(
    val details: CustomerDetails,
    val address: Address
)