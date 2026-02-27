package com.application.onion.application.dto;

import java.time.LocalDate;

public record UpdateUserCommand(String id, String name, LocalDate birthDate) {}
