package com.application.onion.application.service;

import com.application.onion.application.port.in.CommandUseCase;
import com.application.onion.application.port.out.IdGenerator;
import com.application.onion.application.port.out.WriteRepository;
import com.application.onion.domain.User;

import java.util.Objects;

public final class UserCommandService implements CommandUseCase {

    private final IdGenerator idGenerator;
    private final WriteRepository repository;

    public UserCommandService(
            IdGenerator idGenerator,
            WriteRepository repository
    ) {
        this.idGenerator = idGenerator;
        this.repository = repository;
    }

    @Override
    public String createUser(User user) {
        Objects.requireNonNull(user, "User must not be null");
        String newId = idGenerator.nextId();
        User newUser = User.create(newId, user.name(), user.birthDate());
        repository.save(newUser);
        return newId;
    }

    public void updateUser(String id, User user) {
        repository.update(id, user);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }

}
