package com.application.onion.fake;

import com.application.onion.application.port.out.IdGenerator;

public class FakeIdGenerator implements IdGenerator {
    @Override
    public String nextId() {
        return "42"; // фиксированный ID для предсказуемого теста
    }
}
