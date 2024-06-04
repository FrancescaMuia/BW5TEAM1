package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.City;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface CityService {
    List<City> saveCity(Path file) throws IOException;
    List<City> findAllCity();
}
