package com.application.onion.infrastructure.adapter.in.common.dto;

import com.application.onion.application.dto.CreateUserCommand;
import com.application.onion.application.dto.UpdateUserCommand;
import com.application.onion.application.dto.UserView;

import java.time.LocalDate;

public final class Mapper {

    public static CreateUserCommand toCreateCommand(CreateUserRequest request) {
        return new CreateUserCommand(
                request.name(),
                LocalDate.parse(request.birthDate())
        );
    }

    public static UpdateUserCommand toUpdateCommand(String id, UpdateUserRequest body) {
        return new UpdateUserCommand(
                id,
                body.name(),
                LocalDate.parse(body.birthDate())
        );
    }

    public static UserResponse toResponse(UserView view) {
        return new UserResponse(view.id(), view.name(), view.birthDate());
    }

}
