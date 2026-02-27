package com.application.onion.infrastructure.adapter.out.persistence.jooq;

import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.application.port.out.WriteRepository;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Package-private.
 */
@Profile("jooq")
@Configuration
class JooqConfig {

    @Bean
    WriteRepository jooqWriteRepository(DSLContext dsl) {
        return new JooqWriteRepository(dsl);
    }

    @Bean
    ReadRepository jooqReadRepository(DSLContext dsl) {
        return new JooqReadRepository(dsl);
    }
}
