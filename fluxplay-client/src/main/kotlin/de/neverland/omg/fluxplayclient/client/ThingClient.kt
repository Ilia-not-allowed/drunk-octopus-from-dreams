package de.neverland.omg.fluxplayclient.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ThingClient {

    @Bean
    fun client(): WebClient {
        return WebClient.create("http://localhost:8080/")
    }
}
