package com.application.onion.infrastructure.adapter.in.common.dto;

import java.time.LocalDate;

public record Response(String id, String name, LocalDate birthDate) {}
