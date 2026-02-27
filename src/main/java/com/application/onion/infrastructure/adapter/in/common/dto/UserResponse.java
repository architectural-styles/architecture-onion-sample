package com.application.onion.infrastructure.adapter.in.common.dto;

import java.time.LocalDate;

public record UserResponse(String id, String name, LocalDate birthDate) {}
