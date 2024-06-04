package it.epicode.presentationlayer.model;

import jakarta.validation.constraints.NotNull;

public record RoleModel(
        @NotNull String name
) {
}
