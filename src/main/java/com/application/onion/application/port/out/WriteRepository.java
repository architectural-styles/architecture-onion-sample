package com.application.onion.application.port.out;

import com.application.onion.domain.User;

public interface WriteRepository {

    void save(User user);
    void update(String id, User user);
    void deleteById(String id);

}
