package com.emrepbu

import com.emrepbu.core.ProducerConsumerManager
import kotlinx.coroutines.runFor
import kotlinx.coroutines.runBlocking

class App {
    fun runProducerConsumer() = runBlocking {
        var counter = 0
        val manager = ProducerConsumerManager(
            bufferCapacity = 60,
            dataGenerator = { counter++ },
            dataProcessor = { data -> println("Processed: $data") }
        )

        manager.runFor(50000)
        println("Final buffer size: ${manager.getBufferSize()}")
    }
}

fun main() {
    val app = App()
    app.runProducerConsumer()
}