package com.application.onion.application.port.in;

import com.application.onion.domain.User;

import java.util.List;

public interface QueryUseCase {

    User findById(String id);

    List<User> findAll();

    List<User> findByNameStartingWith(String prefix);

}
