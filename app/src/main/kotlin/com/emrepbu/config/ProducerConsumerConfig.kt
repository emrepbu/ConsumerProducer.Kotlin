package com.emrepbu.config

import com.emrepbu.core.ProducerConsumerManager

data class ProducerConsumerConfig<T>(
    val bufferCapacity: Int,
    val dataGenerator: () -> T,
    val dataProcessor: (T) -> Unit,
    val producerDelayMs: Long = 100,
    val consumerDelayMs: Long = 150
) {
    fun createManager(): ProducerConsumerManager<T> {
        return ProducerConsumerManager(
            bufferCapacity = bufferCapacity,
            dataGenerator = dataGenerator,
            dataProcessor = dataProcessor,
            producerDelayMs = producerDelayMs,
            consumerDelayMs = consumerDelayMs
        )
    }
}