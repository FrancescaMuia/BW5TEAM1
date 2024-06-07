package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.City;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAllCities();
    Optional<City> getCityById(Long id);
    City addCity(City city);
    City updateCity(City city);
    void deleteCity(Long id);
    void importCitiesFromCSV(String filePath) throws IOException;
}
