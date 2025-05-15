# Architecture Overview

```
com.emrepbu/
├── App.kt (Main entry point)
│
├── buffer/ (Buffer module)
│   ├── IBuffer.kt (Interface)
│   └── Buffer.kt (Implementation)
│
├── core/ (Core module)
│   ├── IProducer.kt (Interface)
│   ├── IConsumer.kt (Interface)
│   ├── Producer.kt (Implementation)
│   ├── Consumer.kt (Implementation)
│   └── ProducerConsumerManager.kt (Orchestrator)
│
└── config/ (Configuration module)
    └── ProducerConsumerConfig.kt (Config helper)
```

## Design Principles

1. **Separation of Concerns**: Each module has a single responsibility
2. **Interface-based Design**: Core components implement interfaces for flexibility
3. **Dependency Inversion**: High-level modules depend on abstractions, not concrete implementations
4. **Modularity**: Clear module boundaries with well-defined dependencies

## Data Flow

```
App.kt
  └─> ProducerConsumerManager (core/)
      ├─> Producer (core/) ──> IBuffer (buffer/)
      └─> Consumer (core/) ──> IBuffer (buffer/)
```

## Extension Points

- New buffer implementations can be added by implementing `IBuffer`
- Custom producers/consumers can be created by implementing `IProducer`/`IConsumer`
- Configuration can be extended in the `config` module