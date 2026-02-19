package com.application.onion.fake;

import com.application.onion.application.port.out.WriteRepository;
import com.application.onion.domain.User;

public class FakeWriteRepository implements WriteRepository {

    public User lastSaved;
    public User lastUpdated;
    public String lastDeletedId;

    @Override
    public void save(User user) {
        this.lastSaved = user;
    }

    @Override
    public void update(String id, User user) {
        this.lastUpdated = user;
    }

    @Override
    public void deleteById(String id) {
        this.lastDeletedId = id;
    }
}
