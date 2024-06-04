package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.City;
import it.epicode.dataLayer.entities.Province;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ProvinceService {

    List<Province> saveProvince(Path file) throws IOException;
    List<Province> findAllProvinces();


}
