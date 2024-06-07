package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.Province;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface ProvinceService {

    List<Province> getAllProvinces();
    Optional<Province> getProvinceById(Long id);
    Province addProvince(Province province);
    Province updateProvince(Province province);
    void deleteProvince(Long id);
    void importProvincesFromCSV(String filePath) throws IOException;


}
