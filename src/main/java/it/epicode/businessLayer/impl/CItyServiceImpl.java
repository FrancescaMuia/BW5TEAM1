package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.CityService;
import it.epicode.dataLayer.entities.City;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.CityRepository;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CItyServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    static final Path file = Path.of("C:\\Users\\user\\Desktop\\EES\\src\\main\\resources\\CSV\\comuni-italiani.csv");

    // Get all cities
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Get city by ID
    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    // Add a new city
    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // Update an existing city
    @Override
    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    // Delete a city by ID
    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    // Import cities from a CSV file
    @Override
    public void importCitiesFromCSV(String filePath) throws IOException {
        List<City> cityes;
        try {
            cityes = Files.lines(file, StandardCharsets.ISO_8859_1)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(line ->{
                        String provinceName = line[3]; // Assicurati che l'indice sia corretto in base alla struttura del tuo CSV
                        Province province = provinceRepository.findOneByName(provinceName);
                        if (province == null) {
                            log.error("Provincia non trovata per la città: {}", line[2]);
                            return null; // Se non trovi la provincia, salta questa riga del CSV
                        }
                        return City.builder()
                                .withName(line[2])
                                .withProvince(province)
                                .withAddresses(new ArrayList<>())
                                .build();
                    })
                    .filter(Objects::nonNull) // Rimuove eventuali righe con province non trovate
                    .toList();
            cityRepository.saveAll(cityes);
            log.info("Città Salvate");
        } catch (IOException e) {
            log.error("Errore durante il caricamento delle province dal file CSV", e);
            throw e;
        }
    }

}
