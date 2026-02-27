package com.application.onion.infrastructure.adapter.out.persistence.jpa;

import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.domain.User;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Optional;


/**
 * Package-private.
 */
@Profile("jpa")
final class JpaReadRepository implements ReadRepository {

    private final UserJpaRepository jpa;

    public JpaReadRepository(UserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<User> findById(String id) {
        return jpa.findById(id).map(UserJpaMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAllByOrderById().stream().map(UserJpaMapper::toDomain).toList();
    }

    @Override
    public List<User> findByNameStartingWith(String prefix) {
        return jpa.findByNameStartingWithIgnoreCaseOrderByName(prefix).stream().map(UserJpaMapper::toDomain).toList();
    }
}
