package com.example.slowapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SlowApiApplication

fun main(args: Array<String>) {
	runApplication<SlowApiApplication>(*args)
}

@RestController
class Controller {
	@GetMapping
	fun saludar(): String {
		Thread.sleep(2000)
		return "Hola!!!"
	}
}