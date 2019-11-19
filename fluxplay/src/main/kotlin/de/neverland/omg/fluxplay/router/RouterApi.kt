package de.neverland.omg.fluxplay.router

import de.neverland.omg.fluxplay.handler.RequestHandlerMy
import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunctions.route
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Configuration
class RouterApi (
        private val requestHandler: RequestHandlerMy
) {


    @Bean
    fun customRouter() = coRouter {
        ("/things").nest{
            GET("/flow/alot/{amount}", accept(APPLICATION_JSON), requestHandler::alot)
        }
    }

}