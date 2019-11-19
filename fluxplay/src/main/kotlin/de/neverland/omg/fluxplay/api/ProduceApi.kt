package de.neverland.omg.fluxplay.api

import de.neverland.omg.fluxplay.model.Thing
import de.neverland.omg.fluxplay.service.PlayService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
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
    @RequestMapping(path = ["/things/stream/{amount}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getThingsFlowStream(@PathVariable amount: Int): Flow<Thing> {
        return playService.flowThing(amount)
    }


}