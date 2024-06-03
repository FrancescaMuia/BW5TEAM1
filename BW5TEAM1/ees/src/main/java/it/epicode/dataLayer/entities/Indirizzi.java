package it.epicode.dataLayer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Indirizzi extends BaseEntity{
    private String via;
    private int civico;
    private String localita;
    private int cap;
    private String comune;
}
