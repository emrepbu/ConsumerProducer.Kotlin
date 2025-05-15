package com.emrepbu.buffer

interface IBuffer<T> {
    fun add(item: T)
    fun get(): T
    fun hasSpace(): Boolean
    fun hasData(): Boolean
    fun size(): Int
}