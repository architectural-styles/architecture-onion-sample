package com.application.onion.infrastructure.config;

import com.application.onion.application.port.in.CommandUseCase;
import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.application.port.out.IdGenerator;
import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.application.port.out.WriteRepository;
import com.application.onion.application.service.UserCommandService;
import com.application.onion.application.service.UserQueryService;
import com.application.onion.infrastructure.adapter.out.persistence.id.SequentialIdGenerator;
import com.application.onion.infrastructure.adapter.out.persistence.jdbc.JdbcReadRepository;
import com.application.onion.infrastructure.adapter.out.persistence.jdbc.JdbcWriteRepository;
import com.application.onion.infrastructure.adapter.out.persistence.jooq.JooqReadRepository;
import com.application.onion.infrastructure.adapter.out.persistence.jooq.JooqWriteRepository;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
public class AppConfig {

    /* --------------------------------------------------
     *  OUT ADAPTERS: Write Repositories
     * -------------------------------------------------- */

    @Bean
    @Profile("jdbc")
    WriteRepository jdbcWriteRepository(JdbcClient jdbc) {
        return new JdbcWriteRepository(jdbc);
    }

    @Bean
    @Profile("jooq")
    WriteRepository jooqWriteRepository(DSLContext dsl) {
        return new JooqWriteRepository(dsl);
    }

    /* --------------------------------------------------
     *  OUT ADAPTERS: Read Repositories
     * -------------------------------------------------- */

    @Bean
    @Profile("jdbc")
    ReadRepository jdbcReadRepository(JdbcClient jdbc) {
        return new JdbcReadRepository(jdbc);
    }

    @Bean
    @Profile("jooq")
    ReadRepository jooqReadRepository(DSLContext dsl) {
        return new JooqReadRepository(dsl);
    }

    /* --------------------------------------------------
     *  OUT ADAPTERS: Id Generator
     * -------------------------------------------------- */

    @Bean
    IdGenerator idGenerator() {
        return new SequentialIdGenerator();
    }

    /* --------------------------------------------------
     *  CORE: Services (Use Cases)
     * -------------------------------------------------- */

    @Bean
    QueryUseCase queryService(ReadRepository readRepository) {
        return new UserQueryService(readRepository);
    }

    @Bean
    CommandUseCase commandService(
            IdGenerator idGenerator,
            WriteRepository writeRepository
    ) {
        return new UserCommandService(idGenerator, writeRepository);
    }

}
