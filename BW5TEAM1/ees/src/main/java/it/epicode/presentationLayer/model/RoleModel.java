package it.epicode.presentationLayer.model;

import jakarta.validation.constraints.NotNull;

public record RoleModel(
        @NotNull String name
) {
}
