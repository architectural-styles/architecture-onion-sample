package com.application.onion.application.service;

import com.application.onion.application.port.in.CommandUseCase;
import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.application.port.out.WriteRepository;
import org.springframework.context.annotation.Bean;
import com.application.onion.application.port.out.IdGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * Package-private.
 */
@Configuration
class ApplicationConfig {

    @Bean
    CommandUseCase commandService(IdGenerator idGenerator, WriteRepository repo) {
        return new UserCommandService(idGenerator, repo);
    }

    @Bean
    QueryUseCase queryService(ReadRepository repo) {
        return new UserQueryService(repo);
    }
}
