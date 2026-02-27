package com.application.onion.infrastructure.adapter.out.persistence.id;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.application.onion.application.port.out.IdGenerator;

@Configuration
class IdConfig {

    @Bean
    IdGenerator idGenerator() {
        return new UuidV7IdGenerator();
    }
}
