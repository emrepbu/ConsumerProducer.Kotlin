package com.emrepbu.buffer

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class Buffer<T>(capacity: Int) : IBuffer<T> {
    private val queue: BlockingQueue<T> = LinkedBlockingQueue(capacity)
    
    override fun add(item: T) {
        queue.put(item)
    }
    
    override fun get(): T {
        return queue.take()
    }
    
    override fun hasSpace(): Boolean {
        return queue.remainingCapacity() > 0
    }
    
    override fun hasData(): Boolean {
        return !queue.isEmpty()
    }
    
    override fun size(): Int {
        return queue.size
    }
}