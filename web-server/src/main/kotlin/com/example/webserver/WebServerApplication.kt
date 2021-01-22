package com.example.webserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
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
    fun saludar(@RequestParam(name = "responseDelay", required = false) responseDelay: Long?) =
        restTemplate.getForObject("http://localhost:9000?responseDelay=${responseDelay?:2000}", String::class.java)

}
