package com.example.webfluxserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@SpringBootApplication
class WebfluxServerApplication

fun main(args: Array<String>) {
	runApplication<WebfluxServerApplication>(*args)
}

@RestController
class ControllerNoBloqueante (private val webClient: WebClient = WebClient.create()){

	@GetMapping
	fun saludar() = webClient
		.get()
		.uri("http://localhost:9000")
		.exchangeToMono { it.bodyToMono(String::class.java) }
}

@RestController
class ControllerBloqueante (private val restTemplate: RestTemplate = RestTemplate()){

	@GetMapping("/bloqueante")
	fun saludar() = restTemplate.getForObject("http://localhost:9000", String::class.java)
}