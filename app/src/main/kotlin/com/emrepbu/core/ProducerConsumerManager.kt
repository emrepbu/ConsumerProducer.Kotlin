package com.emrepbu.core

import com.emrepbu.buffer.Buffer
import kotlinx.coroutines.*

class ProducerConsumerManager<T>(
    private val bufferCapacity: Int,
    private val dataGenerator: () -> T,
    private val dataProcessor: (T) -> Unit,
    private val producerDelayMs: Long = 100,
    private val consumerDelayMs: Long = 150
) {
    private val buffer = Buffer<T>(bufferCapacity)
    private var producerJob: Job? = null
    private var consumerJob: Job? = null
    
    suspend fun start() {
        producerJob = CoroutineScope(Dispatchers.Default).launch {
            Producer(buffer, dataGenerator, producerDelayMs).run()
        }
        
        consumerJob = CoroutineScope(Dispatchers.Default).launch {
            Consumer(buffer, dataProcessor, consumerDelayMs).run()
        }
    }
    
    suspend fun stop() {
        producerJob?.cancel()
        consumerJob?.cancel()
        producerJob?.join()
        consumerJob?.join()
    }
    
    fun getBufferSize(): Int = buffer.size()
    
    fun hasSpace(): Boolean = buffer.hasSpace()
    
    fun hasData(): Boolean = buffer.hasData()
    
    suspend fun runFor(durationMs: Long) {
        start()
        delay(durationMs)
        stop()
    }
}