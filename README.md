# Consumer Producer Kotlin

## Project Overview

This is a Kotlin Consumer/Producer project using Gradle as the build system. The main application is located in the `app` module.

## Build Commands

```bash
# Build the project
./gradlew build
```

```bash
# Run the application
./gradlew run
```


```bash
# Run tests
./gradlew test
```

```bash
# Clean build artifacts
./gradlew clean
```

```bash
# Check all code (runs all verification tasks)
./gradlew check
```

## Project Structure

- The main application code is in `app/src/main/kotlin/com/emrepbu/`
- Tests are located in `app/src/test/kotlin/com/emrepbu/`
- Build configuration is in `app/build.gradle.kts`
- Version catalog is in `gradle/libs.versions.toml`

## Key Files

- `app/src/main/kotlin/com/emrepbu/App.kt` - Main application entry point
- `app/build.gradle.kts` - Build configuration including dependencies
- `gradle/libs.versions.toml` - Dependency version management

## Technology Stack

- Kotlin JVM
- Gradle 8.14
- Java 21 toolchain
- Kotlin Test framework for testing
- Guava as a core dependency