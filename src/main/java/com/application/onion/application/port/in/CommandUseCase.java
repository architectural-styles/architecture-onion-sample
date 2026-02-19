package com.application.onion.application.port.in;

import com.application.onion.domain.User;

public interface CommandUseCase {

    String createUser(User user);

    void updateUser(String id, User user);

    void deleteUser(String id);

}
