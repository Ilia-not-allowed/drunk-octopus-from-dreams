package de.neverland.omg.fluxplay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class FluxplayApplication

fun main(args: Array<String>) {
	runApplication<FluxplayApplication>(*args)
}
