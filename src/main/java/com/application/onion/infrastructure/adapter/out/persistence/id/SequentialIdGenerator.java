package com.application.onion.infrastructure.adapter.out.persistence.id;

import com.application.onion.application.port.out.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;


public class SequentialIdGenerator implements IdGenerator {

    private final AtomicLong seq = new AtomicLong(3);

    @Override
    public String nextId() {
        return String.valueOf(seq.incrementAndGet());
    }
}
