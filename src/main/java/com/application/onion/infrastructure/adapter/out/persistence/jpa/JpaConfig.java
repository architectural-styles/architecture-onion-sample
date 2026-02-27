package com.application.onion.infrastructure.adapter.out.persistence.jpa;

import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.application.port.out.WriteRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Package-private.
 */
@Profile("jpa")
@Configuration
class JpaConfig {

    @Bean
    WriteRepository jpaWriteRepository(EntityManager em) {
        return new JpaWriteRepository(em);
    }

    @Bean
    ReadRepository jpaReadRepository(UserJpaRepository jpa) {
        return new JpaReadRepository(jpa);
    }
}
