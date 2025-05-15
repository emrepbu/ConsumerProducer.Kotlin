package com.emrepbu.core

import com.emrepbu.buffer.IBuffer
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.coroutines.coroutineContext

class Consumer<T>(
    private val buffer: IBuffer<T>,
    private val dataProcessor: (T) -> Unit,
    private val delayMs: Long = 150
) : IConsumer {
    override suspend fun run() {
        while (coroutineContext.isActive) {
            if (buffer.hasData()) {
                val data = buffer.get()
                println("Consumer: Processing $data")
                dataProcessor(data)
            } else {
                println("Consumer: Buffer empty, waiting...")
                delay(10)
            }
            delay(delayMs)
        }
    }
}