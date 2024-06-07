package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.service.ProvinceService;
import it.epicode.dataLayer.entities.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @Value("${province_file}")
    private String provinceFile;

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    @PostMapping
    public String importProvince() throws IOException {
        provinceService.importProvincesFromCSV(provinceFile);
        return "Province importate con successo dal percorso file!";
    }

}
