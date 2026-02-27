package com.application.onion.application.port.out;

import com.application.onion.domain.User;

/**
 * Port for writing users to the data store.
 * Implementations are provided per infrastructure profile: jdbc, jooq, jpa.
 */
public interface WriteRepository {

    /**
     * Persists a new user.
     */
    void save(User user);

    /**
     * Updates an existing user.
     * Throws {@link com.application.onion.domain.UserNotFoundException}
     * if no user exists with the given ID.
     */
    void update(User user);

    /**
     * Deletes a user by ID.
     * Throws {@link com.application.onion.domain.UserNotFoundException}
     * if no user exists with the given ID.
     */
    void deleteById(String id);
}
