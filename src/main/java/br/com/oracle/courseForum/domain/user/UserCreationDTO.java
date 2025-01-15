package br.com.oracle.courseForum.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record UserCreationDTO(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Email is required")
        @Email
        String email,
        @NotBlank(message="Password is required")
        String password,
        boolean admin
) {
}
