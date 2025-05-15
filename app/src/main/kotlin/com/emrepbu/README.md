# Producer-Consumer Pattern - Modular Implementation

This is a modular implementation of the Producer-Consumer pattern in Kotlin using coroutines.

## Core Components

### 1. Buffer
Thread-safe buffer implementation using `BlockingQueue`.

### 2. Producer
Generates data and adds it to the buffer when space is available.

### 3. Consumer
Retrieves data from the buffer and processes it when data is available.

### 4. ProducerConsumerManager
Manages producer and consumer coroutines with configurable parameters.

### 5. ProducerConsumerConfig
Configuration data class for creating scenarios.

## Usage Examples

### Basic Usage
```kotlin
val manager = ProducerConsumerManager(
    bufferCapacity = 50,
    dataGenerator = { counter++ },
    dataProcessor = { data -> println("Processed: $data") },
    producerDelayMs = 100,
    consumerDelayMs = 150
)

manager.runFor(5000) // Run for 5 seconds
```

### Using Configuration
```kotlin
val config = ProducerConsumerConfig(
    bufferCapacity = 20,
    dataGenerator = { generateData() },
    dataProcessor = { processData(it) },
    producerDelayMs = 50,
    consumerDelayMs = 100
)

val manager = config.createManager()
manager.runFor(10000)
```

### Custom Data Types
```kotlin
data class Message(val id: Int, val content: String)

val config = ProducerConsumerConfig<Message>(
    bufferCapacity = 30,
    dataGenerator = { Message(id++, "Message $id") },
    dataProcessor = { msg -> println("Processing: ${msg.content}") }
)
```

## Running

Run the application with:
```bash
./gradlew run
```

## API Reference

### ProducerConsumerManager Methods
- `start()` - Start producer and consumer coroutines
- `stop()` - Stop producer and consumer coroutines  
- `runFor(durationMs)` - Run for specified duration
- `getBufferSize()` - Get current buffer size
- `hasSpace()` - Check if buffer has space
- `hasData()` - Check if buffer has data