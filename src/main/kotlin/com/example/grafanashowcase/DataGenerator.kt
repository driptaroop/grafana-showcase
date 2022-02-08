package com.example.grafanashowcase

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

fun main() {
    val objectmapper = jacksonObjectMapper()
    (1..50).map { mapOf("customerId" to it) }.toList()
        .let {
            objectmapper.writeValue(File("./config/newman/data.json"), it)
        }
}
