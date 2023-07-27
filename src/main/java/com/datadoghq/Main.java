package com.datadoghq;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

public class Main {
    public static final Tracer tracer = GlobalOpenTelemetry.getTracer("demo");

    public static void main(String[] args) {
        System.out.println(">>> STEP 1: Dumping span context without active span");
        dumpSpanContext();

        System.out.println(">>> STEP 2: Dumping span context with a span");
        Span span = tracer.spanBuilder("operation").startSpan();
        dumpSpanContext();

        System.out.println(">>> STEP 3: Dumping span context with an active span");
        try (Scope scope = span.makeCurrent()) {
            dumpSpanContext();
        }
        span.end();

        System.out.println(">>> STEP 4: Dumping span context with a span no more active");
        dumpSpanContext();

        System.out.println(">>> STEP 5: Dumping span context with a closed span");
        dumpSpanContext();
    }

    public static void dumpSpanContext() {
        Span current = Span.current();
        SpanContext spanContext = current.getSpanContext();
        System.out.println("Trace ID: "+spanContext.getTraceId() + " | Span ID: "+spanContext.getSpanId());
    }
}