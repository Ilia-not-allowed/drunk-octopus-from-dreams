package de.neverland.omg.fluxplay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FluxplayApplication

fun main(args: Array<String>) {
	runApplication<FluxplayApplication>(*args)
}
