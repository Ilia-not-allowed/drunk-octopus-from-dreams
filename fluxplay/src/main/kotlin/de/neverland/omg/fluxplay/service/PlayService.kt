package de.neverland.omg.fluxplay.service

import de.neverland.omg.fluxplay.model.Thing
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlayService(
        private val thingGenerator: ThingGenerator
) {
    fun singleThing(): Mono<Thing> {
        return Mono.just(thingGenerator.createThing())
    }

    fun singleThingNotMono(): Thing {
        return thingGenerator.createThing()
    }

    fun listThing(amount: Int): List<Thing> {
        val things = mutableListOf<Thing>()
        repeat(amount) {
            things.add(thingGenerator.createThing())
        }
        return things
    }

    @ExperimentalCoroutinesApi
    fun flowThing(amount: Int): Flow<Thing> = flow {
        for (i in 1..amount) {
            delay(200)
            println("number $i")
            emit(thingGenerator.createThing())
        }
    }
}