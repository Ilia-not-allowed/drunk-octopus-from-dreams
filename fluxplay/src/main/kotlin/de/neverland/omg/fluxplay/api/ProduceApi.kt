package de.neverland.omg.fluxplay.api

import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.Disposable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.temporal.TemporalAmount

@RestController
class ProduceApi(
        val playService: PlayService
) {

    @GetMapping("/single/mono")
    fun getSingleMono(): Mono<Thing> {
        return playService.singleThing()
    }

    @GetMapping("/single")
    fun getSingleItem(): Thing {
        return playService.singleThingNotMono()
    }

    @GetMapping("/things/{amount}")
    fun getListMono(@PathVariable amount: Int): List<Thing> {
        return playService.listThing(amount)
    }

    @ExperimentalCoroutinesApi
    @GetMapping("/things/flow/{amount}")
    fun getThingsFlow(@PathVariable amount: Int): Flow<Thing> {
        return playService.flowThing(amount)
    }

    @ExperimentalCoroutinesApi
    @RequestMapping(path = ["/things/stream/"],
            method = [RequestMethod.GET],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun getThingsFlowStream(): Flow<Thing> {
        return playService.flowThing()
    }

    @ExperimentalCoroutinesApi
    @RequestMapping(path = ["/things/flux"],
            method = [RequestMethod.GET],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getThingsAsFlux(): Flux<Thing> {
        println("traditional endpoint")
        return playService.fluxThing()
    }

}
