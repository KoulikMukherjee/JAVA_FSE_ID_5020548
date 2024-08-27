package com.Bookstore.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class CustomerCustomMetrics {

    private final Counter customerCreatedCounter;
    private final Counter customerDeletedCounter;

    public CustomerCustomMetrics(MeterRegistry meterRegistry) {
        this.customerCreatedCounter = meterRegistry.counter("customers_created_total");
        this.customerDeletedCounter = meterRegistry.counter("customers_deleted_total");
    }

    public void incrementCustomerCreated() {
        customerCreatedCounter.increment();
    }

    public void incrementCustomerDeleted() {
        customerDeletedCounter.increment();
    }
}