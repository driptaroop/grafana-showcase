package com.example.grafanashowcase

import com.github.javafaker.Faker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.filter.CommonsRequestLoggingFilter
import javax.servlet.http.HttpServletRequest

@SpringBootApplication
class GrafanaShowcaseApplication

fun main(args: Array<String>) {
    runApplication<GrafanaShowcaseApplication>(*args)
}


@Configuration
class WebConfig {
    private val EXCLUDE_PATH: String = "/actuator"
    @Bean fun restTemplate() = RestTemplate()
    @Bean
    fun logFilter(): CommonsRequestLoggingFilter =
        CommonsRequestLoggingFilter().apply {
            setIncludeQueryString(true)
            setIncludeHeaders(true)
            setIncludeClientInfo(true)
        }
}