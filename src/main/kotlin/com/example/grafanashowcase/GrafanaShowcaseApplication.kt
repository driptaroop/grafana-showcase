package com.example.grafanashowcase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrafanaShowcaseApplication

fun main(args: Array<String>) {
    runApplication<GrafanaShowcaseApplication>(*args)
}
