package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.services.CityService;
import it.epicode.dataLayer.entities.City;
import it.epicode.dataLayer.repositories.CityRepository;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    static final Path file = Path.of("C:\\Users\\user\\Desktop\\BW5TEAM1\\BW5TEAM1\\ees\\src\\main\\resources\\data\\comuni-italiani.csv");

    @Override
    public List<City> saveCity(Path file) throws IOException {
        List<City> cityes;
        try {
            cityes = Files.lines(file, StandardCharsets.ISO_8859_1)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(line -> City.builder()
                            .withProvince(provinceRepository.findOneByName(line[3]))
                            .withName(line[2])
                            .build())
                    .toList();
            cityRepository.saveAll(cityes);
            log.info("Città Salvate");
        } catch (IOException e) {
            log.error("Errore durante il caricamento delle province dal file CSV", e);
            throw e;
        }
        return cityes;
    }

    @Override
    public List<City> findAllCity() {
        return List.of();
    }
}
