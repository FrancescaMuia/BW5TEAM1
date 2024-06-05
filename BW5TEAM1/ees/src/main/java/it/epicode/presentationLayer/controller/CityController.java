package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.services.CityService;
import it.epicode.businessLayer.services.ProvinceService;
import it.epicode.dataLayer.entities.City;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CityController {

    @Autowired
    CityRepository cities;

    @Autowired
    private CityService cityService;

    @Value("${city_file}")
    private String cityFile;

    @PostMapping
    public String importCities() throws IOException {
        cityService.saveCity(Path.of(cityFile));
        return "Città importate con successo dal percorso file!";
    }

    @GetMapping
    public List<City> getProvincia() throws IOException {
        return cities.findAll();
    }

}
