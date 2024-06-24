package az.company.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroServiceApplication

fun main(args: Array<String>) {
	runApplication<MicroServiceApplication>(*args)
}
