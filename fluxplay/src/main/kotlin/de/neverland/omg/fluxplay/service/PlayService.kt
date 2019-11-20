package de.neverland.omg.fluxplay.service

import de.neverland.omg.fluxplay.model.Thing
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.function.BiFunction
import java.util.stream.Stream

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

    fun flowThing(amount: Int): Flow<Thing> = flow {
        repeat(amount){
            println("generate flow $it")
            delay(1000)
            emit(thingGenerator.createThing())
        }
    }

    fun flowThing(): Flow<Thing> = flow {
        for(i in 1..2000){ // just for quick counting
            println("generate flow $i")
            delay(1000)
            emit(thingGenerator.createThing())
        }
    }

    fun fluxThing(): Flux<Thing> {
        return Flux.fromStream(Stream.generate {
            println("generate called")
            Thread.sleep(1000)
            thingGenerator.createThing() })
    }

    suspend fun getAmountOfThings(amount: Int): MutableList<Thing> {
        val things = mutableListOf<Thing>()
        for (i in 1..amount) {
            delay(200)
            things.add(thingGenerator.createThing())
        }
        return things
    }
}
