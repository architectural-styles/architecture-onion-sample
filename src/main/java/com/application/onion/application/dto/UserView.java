package com.application.onion.application.dto;

import java.time.LocalDate;

public record UserView(String id, String name, LocalDate birthDate) {}
