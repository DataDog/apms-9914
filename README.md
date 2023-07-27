# APMS-9914

## Description

This demo project aims to demonstrate OpenTelemetry API usage when using Datadog Java tracer.

## Usage

1. Download [the Datadog Java Tracer from GitHub](https://github.com/DataDog/dd-trace-java/releases/latest/download/dd-java-agent.jar) and store the downloaded `dd-java-agent-jar` in the project root folder,
2. Build the project using Maven
   * Using `./mvnw package` for Linux/MacOS
   * USing `mvnw package` for Windows
3. Run the demo application using Java: `java -javaagent:dd-java-agent.jar -Ddd.trace.otel.enabled=true -jar target/apms-9914-1.0.0.jar`
   * Java 8+ is required,
   * `-javaagent:dd-java-agent.jar` will install the Datadog Java tracer,
   * `-Ddd.trace.otel.enabled=true` will activate OpenTelemetry support,
   * `-jar target/apms-9914-1.0.0.jar` will run the previous built demo application.

Here is the expected output:
```
>>> STEP 1: Dumping span context without active span
Trace ID: 00000000000000000000000000000000 | Span ID: 0000000000000000
>>> STEP 2: Dumping span context with a span
Trace ID: 00000000000000000000000000000000 | Span ID: 0000000000000000
>>> STEP 3: Dumping span context with an active span
Trace ID: 00000000000000003eafb854fc83440f | Span ID: 12793037eeb2b6db
>>> STEP 4: Dumping span context with a span no more active
Trace ID: 00000000000000000000000000000000 | Span ID: 0000000000000000
>>> STEP 5: Dumping span context with a closed span
Trace ID: 00000000000000000000000000000000 | Span ID: 0000000000000000
```

_Note: All commands are expected to be run from the project root._





