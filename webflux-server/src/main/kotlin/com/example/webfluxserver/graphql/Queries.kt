package com.example.webfluxserver.graphql

import com.expediagroup.graphql.spring.operations.Query
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

@Component
class Queries(
    private val webClient: WebClient = WebClient.create(),
    private val okHttp: OkHttpClient = OkHttpClient()
) : Query {

    fun bloqueante(): String {
        val request: Request = Request.Builder()
            .url("http://localhost:9000")
            .build()

        return okHttp.newCall(request).execute().use { response -> response.body?.string()!! }
    }

    fun noBloqueante(): Future<String> {
        return webClient
            .get()
            .uri("http://localhost:9000")
            .exchangeToMono { it.bodyToMono(String::class.java) }
            .toFuture()
    }
}