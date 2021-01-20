package com.example.webserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class WebServerApplication

fun main(args: Array<String>) {
    runApplication<WebServerApplication>(*args)
}

@RestController
class Controller(private val restTemplate: RestTemplate = RestTemplate()) {

    @GetMapping
    fun saludar() = restTemplate.getForObject("http://localhost:9000", String::class.java)

}
