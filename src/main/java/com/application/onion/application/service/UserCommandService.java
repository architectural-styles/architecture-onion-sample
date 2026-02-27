package com.application.onion.application.service;

import com.application.onion.application.dto.CreateUserCommand;
import com.application.onion.application.dto.UpdateUserCommand;
import com.application.onion.application.port.in.CommandUseCase;
import com.application.onion.application.port.out.IdGenerator;
import com.application.onion.application.port.out.WriteRepository;
import com.application.onion.domain.User;

import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;


/**
 * Package-private.
 */
class UserCommandService implements CommandUseCase {

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
    @Transactional
    public String createUser(CreateUserCommand command) {
        Objects.requireNonNull(command, "User must not be null");
        String newId = idGenerator.nextId();
        repository.save(new User(newId, command.name(), command.birthDate()));
        return newId;
    }

    @Override
    @Transactional
    public void updateUser(UpdateUserCommand command) {
        repository.update(new User(command.id(), command.name(), command.birthDate()));
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}