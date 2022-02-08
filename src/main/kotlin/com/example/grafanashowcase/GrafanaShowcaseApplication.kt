package com.example.grafanashowcase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter
import javax.servlet.http.HttpServletRequest

@SpringBootApplication
class GrafanaShowcaseApplication

fun main(args: Array<String>) {
    runApplication<GrafanaShowcaseApplication>(*args)
}


@Configuration
class RequestLoggingFilterConfig {
    private val EXCLUDE_PATH: String = "/actuator"

    @Bean
    fun logFilter(): CommonsRequestLoggingFilter =
        CommonsRequestLoggingFilter().apply {
            setIncludeQueryString(true)
            setIncludeHeaders(true)
            setIncludeClientInfo(true)
        }
}