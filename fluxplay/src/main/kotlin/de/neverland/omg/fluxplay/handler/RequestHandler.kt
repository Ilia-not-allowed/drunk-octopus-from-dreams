package de.neverland.omg.fluxplay.handler

import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Component
class RequestHandlerMy(val playService: PlayService) {

    @ExperimentalCoroutinesApi
    suspend fun alot(request: ServerRequest): ServerResponse {
        print("invoked")
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .bodyAndAwait(playService.flowThing(amount = request.pathVariable("amount").toInt()))
    }

    fun alotFlux(request: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(playService.fluxThing(), Thing::class.java)
    }

}
