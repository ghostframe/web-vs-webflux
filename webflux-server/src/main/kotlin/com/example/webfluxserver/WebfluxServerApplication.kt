package com.example.webfluxserver

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class WebfluxServerApplication

fun main(args: Array<String>) {
	runApplication<WebfluxServerApplication>(*args)
}

@RestController
class ControllerNoBloqueante (private val webClient: WebClient = WebClient.create()){

	@GetMapping
	fun saludar(@RequestParam(name = "responseDelay", required = false) responseDelay: Long?) = webClient
		.get()
		.uri("http://localhost:9000?responseDelay=${responseDelay?:2000}")
		.exchangeToMono { it.bodyToMono(String::class.java) }
}

@RestController
class ControllerBloqueante (private val okHttp: OkHttpClient = OkHttpClient()){

	@GetMapping("/bloqueante")
	fun saludar(@RequestParam(name = "responseDelay", required = false) responseDelay: Long?): String {
		val request: Request = Request.Builder()
			.url("http://localhost:9000?responseDelay=${responseDelay?:2000}")
			.build()

		return okHttp.newCall(request).execute().use { response -> response.body?.string()!! }
	}
}