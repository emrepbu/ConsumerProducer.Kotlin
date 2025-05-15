# Module Structure

The code is organized into the following modules:

## buffer/
Contains the buffer implementation:
- `IBuffer.kt` - Interface defining buffer operations
- `Buffer.kt` - Concrete implementation using BlockingQueue

## core/
Contains the core producer-consumer logic:
- `IProducer.kt` - Interface for producers
- `IConsumer.kt` - Interface for consumers
- `Producer.kt` - Producer implementation
- `Consumer.kt` - Consumer implementation
- `ProducerConsumerManager.kt` - Orchestrates producer and consumer

## config/
Contains configuration utilities:
- `ProducerConsumerConfig.kt` - Configuration data class for creating managers

## Root Level
- `App.kt` - Main application entry point
- `README.md` - Documentation
- `MODULE_STRUCTURE.md` - This file

## Module Dependencies
- `buffer` module has no dependencies
- `core` module depends on `buffer`
- `config` module depends on `core`
- `App` depends on `core` and may optionally use `config`