package com.application.onion.application.port.out;

import com.application.onion.domain.User;

import java.util.List;
import java.util.Optional;

public interface ReadRepository {

    Optional<User> findById(String id);
    List<User> findAll();
    List<User> findByNameStartingWith(String prefix);

}
