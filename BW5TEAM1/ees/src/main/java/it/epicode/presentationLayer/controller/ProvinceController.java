package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.services.ProvinceService;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ProvinceRepository;
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
@RequestMapping("api/provinces")
public class ProvinceController {


    @Autowired
    ProvinceRepository province;

    @Autowired
    private ProvinceService provinceService;

    @Value("${province_file}")
    private String provinceFile;



    @PostMapping
    public String importProvince() throws IOException {
        provinceService.saveProvince(Path.of(provinceFile));
        return "Province importate con successo dal percorso file!";
    }

    @GetMapping
    public List<Province> getProvincia() throws IOException {
        return province.findAll();
    }
}