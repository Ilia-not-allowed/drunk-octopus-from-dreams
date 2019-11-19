package de.neverland.omg.fluxplay.router

import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Configuration
class RouterApi (
        val playService: PlayService
) {

//    @Bean
//    fun playApiFunction(): RouterFunction<?> {
//
//        return route(GET("/single"), this::single)
//    }

    fun single(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(playService.singleThing(), Thing::class.java)
    }

}