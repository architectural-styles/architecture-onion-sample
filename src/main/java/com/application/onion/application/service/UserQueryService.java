package com.application.onion.application.service;

import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.domain.User;
import com.application.onion.domain.UserNotFoundException;

import java.util.List;

public final class UserQueryService implements QueryUseCase {

    private final ReadRepository users;

    public UserQueryService(ReadRepository users) { this.users = users;}

    public User findById(String id) {
        return users.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> findAll() {
        return users.findAll();
    }

    public List<User> findByNameStartingWith(String prefix) {
        return users.findByNameStartingWith(prefix);
    }

}
