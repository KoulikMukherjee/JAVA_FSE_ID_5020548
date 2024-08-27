package com.Bookstore.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class BookCustomMetrics {

    private final Counter bookCreatedCounter;
    private final Counter bookDeletedCounter;

    public BookCustomMetrics(MeterRegistry meterRegistry) {
        this.bookCreatedCounter = meterRegistry.counter("books_created_total");
        this.bookDeletedCounter = meterRegistry.counter("books_deleted_total");
    }

    public void incrementBookCreated() {
        bookCreatedCounter.increment();
    }

    public void incrementBookDeleted() {
        bookDeletedCounter.increment();
    }
}