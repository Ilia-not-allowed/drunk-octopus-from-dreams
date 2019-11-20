package de.neverland.omg.fluxplayclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FluxplayClientApplication

fun main(args: Array<String>) {
	runApplication<FluxplayClientApplication>(*args)
}
