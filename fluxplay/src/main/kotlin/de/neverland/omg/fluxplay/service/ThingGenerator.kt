package de.neverland.omg.fluxplay.service

import de.neverland.omg.fluxplay.model.Thing
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ThingGenerator {

    fun createThing(): Thing  = Thing(name= "thing-" + Random.nextInt(1, 100),
            age= Random.nextInt(1, 100))

}