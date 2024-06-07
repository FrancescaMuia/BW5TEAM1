package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.service.CityService;
import it.epicode.dataLayer.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Value("${city_file}")
    private String cityFile;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @PostMapping
    public String importCities() throws IOException {
        cityService.importCitiesFromCSV(cityFile);
        return "Città importate con successo dal percorso file!";
    }
}
