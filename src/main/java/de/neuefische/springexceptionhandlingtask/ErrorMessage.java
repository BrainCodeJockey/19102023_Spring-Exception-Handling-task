package de.neuefische.springexceptionhandlingtask;

public record ErrorMessage(
        String errorMessage,
        java.time.LocalDateTime timestamp) {
}
