package it.epicode.businessLayer.impl;


import it.epicode.businessLayer.services.ProvinceService;

import it.epicode.dataLayer.entities.Province;
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
public class ProvinceServiceImpl implements ProvinceService {
    private static final Logger log = LoggerFactory.getLogger(ProvinceServiceImpl.class);
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CityRepository cityRepository;

    static final Path file = Path.of("C:\\Users\\user\\Desktop\\BW5TEAM1\\BW5TEAM1\\ees\\src\\main\\resources\\data\\province-italiane.csv");


    @Override
    public List<Province> saveProvince(Path file) throws IOException {
        List<Province> province;
        try {
            province = Files.lines(file, StandardCharsets.ISO_8859_1)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(line -> Province.builder()
                            .withRegion(line[2])
                            .withAcronym(line[0])
                            .withName(line[1])
                            .build())
                    .toList();
            provinceRepository.saveAll(province);
            log.info("Province Salvate");
        } catch (IOException e) {
            log.error("Errore durante il caricamento delle province dal file CSV", e);
            throw e;
        }
        return province;
    }

    @Override
    public List<Province> findAllProvinces() {
        return provinceRepository.findAll();
    }
}
