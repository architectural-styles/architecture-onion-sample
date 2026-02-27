package com.application.onion.infrastructure.adapter.out.persistence.jpa;

import com.application.onion.domain.User;

/** Package-private.*/
final class UserJpaMapper {

    static UserJpaEntity toEntity(User user) {
        return new UserJpaEntity(user.id(), user.name(), user.birthDate());
    }

    static User toDomain(UserJpaEntity e) {
        return new User(e.id(), e.name(), e.birthDate());
    }

    private UserJpaMapper() {}
}