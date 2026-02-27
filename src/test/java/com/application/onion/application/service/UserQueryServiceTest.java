package com.application.onion.application.service;

import com.application.onion.application.dto.UserView;
import com.application.onion.domain.UserNotFoundException;
import com.application.onion.fake.FakeReadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserQueryServiceTest {

    private UserQueryService service;

    @BeforeEach
    void setUp() {
        service = new UserQueryService(new FakeReadRepository());
    }

    @Test
    void findById_returnsUser() {
        UserView view = service.findById("1");

        assertEquals("Alice", view.name());
    }

    @Test
    void findById_throwsIfNotFound() {
        assertThrows(UserNotFoundException.class,
                () -> service.findById("999")
        );
    }

    @Test
    void findAll_returnsTwoUsers() {
        List<UserView> views = service.findAll();

        assertEquals(2, views.size());
    }

    @Test
    void findByNameStartsWith_filtersCorrectly() {
        List<UserView> views = service.findByNameStartingWith("A");

        assertEquals(1, views.size());
        assertEquals("Alice", views.get(0).name());
    }

}
