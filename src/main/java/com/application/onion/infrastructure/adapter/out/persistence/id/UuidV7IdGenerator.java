package com.application.onion.infrastructure.adapter.out.persistence.id;

import com.application.onion.application.port.out.IdGenerator;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;

/**
 * Package-private.
 */
final class UuidV7IdGenerator implements IdGenerator {

    private static final
    TimeBasedEpochGenerator GENERATOR =
            Generators.timeBasedEpochGenerator();


    @Override
    public String nextId() {
        return GENERATOR.generate().toString();
    }
}