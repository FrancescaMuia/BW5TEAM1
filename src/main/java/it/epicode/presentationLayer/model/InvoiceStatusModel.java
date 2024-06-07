package it.epicode.presentationLayer.model;

import jakarta.validation.constraints.NotNull;

public record InvoiceStatusModel(
        @NotNull String name
) {
}
