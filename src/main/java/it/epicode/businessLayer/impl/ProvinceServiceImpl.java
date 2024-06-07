package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.ProvinceService;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    static final Path file = Path.of("C:\\Users\\user\\Desktop\\EES\\src\\main\\resources\\CSV\\province-italiane.csv");


    // Get all provinces
    @Override
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    // Get province by ID
    @Override
    public Optional<Province> getProvinceById(Long id) {
        return provinceRepository.findById(id);
    }

    // Add a new province
    @Override
    public Province addProvince(Province province) {
        return provinceRepository.save(province);
    }

    // Update an existing province
    @Override
    public Province updateProvince(Province province) {
        return provinceRepository.save(province);
    }

    // Delete a province by ID
    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    // Import provinces from a CSV file
    @Override
    public void importProvincesFromCSV(String filePath) throws IOException {
        List<Province> provinces;
        try {
            provinces= Files.lines(file, StandardCharsets.ISO_8859_1)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(line -> Province.builder()
                            .withRegion(line[2])
                            .withAcronym(line[0])
                            .withName(line[1])
                            .build())
                    .toList();
            provinceRepository.saveAll(provinces);
            log.info("Province Salvate");
        } catch (IOException e) {
            log.error("Errore durante il caricamento delle province dal file CSV", e);
            throw e;
        }
    }
}

