package com.application.onion.application.dto;

import java.time.LocalDate;

public record CreateUserCommand(String name, LocalDate birthDate) {}
