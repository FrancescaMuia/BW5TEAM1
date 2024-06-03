package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Fatture;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface FattureRepository extends JpaAttributeConverter<Fatture, Long> {
}
