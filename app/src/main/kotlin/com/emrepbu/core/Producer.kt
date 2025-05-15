package com.emrepbu.core

import com.emrepbu.buffer.IBuffer
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.coroutines.coroutineContext

class Producer<T>(
    private val buffer: IBuffer<T>,
    private val dataGenerator: () -> T,
    private val delayMs: Long = 100
) : IProducer {
    override suspend fun run() {
        while (coroutineContext.isActive) {
            val data = dataGenerator()
            if (buffer.hasSpace()) {
                buffer.add(data)
                println("Producer: Added $data to buffer")
            } else {
                println("Producer: Buffer full, waiting...")
                delay(10)
            }
            delay(delayMs)
        }
    }
}