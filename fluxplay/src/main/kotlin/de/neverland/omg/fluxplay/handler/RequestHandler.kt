package de.neverland.omg.fluxplay.handler

import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class RequestHandlerMy(val playService: PlayService) {

    @ExperimentalCoroutinesApi
    suspend fun alot(request: ServerRequest): ServerResponse {
        print("invoked")
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .bodyAndAwait(playService.flowThing(amount = request.pathVariable("amount").toInt()))
    }

}