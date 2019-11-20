package de.neverland.omg.fluxplayclient.api

import de.neverland.omg.fluxplayclient.model.Thing
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow

@RestController
class PlayClientApi(val webClient: WebClient) {

    @ExperimentalCoroutinesApi
    @RequestMapping(path = ["/client/flow/{amount}"],
            method = [RequestMethod.GET],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun startPoll(@PathVariable("amount") amount: Int): Flow<Thing> {
        return webClient.get().uri("/things/stream/$amount").retrieve().bodyToFlow()
    }
}
