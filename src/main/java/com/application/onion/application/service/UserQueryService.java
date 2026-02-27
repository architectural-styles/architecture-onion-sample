package com.application.onion.application.service;

import com.application.onion.application.dto.UserView;
import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.application.port.out.ReadRepository;
import com.application.onion.domain.User;
import com.application.onion.domain.UserNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package-private.
 */
@Transactional(readOnly = true)
class UserQueryService implements QueryUseCase {

    private final ReadRepository users;

    public UserQueryService(ReadRepository users) {
        this.users = users;
    }

    public UserView findById(String id) {
        return toView(
                users.findById(id).orElseThrow(() -> new UserNotFoundException(id))
        );
    }

    public List<UserView> findAll() {
        return users.findAll().stream().map(this::toView).toList();
    }

    public List<UserView> findByNameStartingWith(String prefix) {
        return users.findByNameStartingWith(prefix).stream().map(this::toView).toList();
    }

    private UserView toView(User u) {
        return new UserView(u.id(), u.name(), u.birthDate());
    }
}