package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Comuni;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ComuniRepository;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ComuniService {

    @Autowired
    private ComuniRepository comuneRepo;

    @Autowired
    private ProvinceRepository provinciaRepo;

    @PostConstruct
    public void init() {
        String csvfile="src/main/resources/comuni-italiani.csv";
        String line;

        try (BufferedReader br=new BufferedReader(new FileReader(csvfile))) {
            while ((line = br.readLine()) != null){
                String[] data = line.split(";");
                Comuni comune = new Comuni();
                comune.setNome(data[1]);

                Province provincia = provinciaRepo.findByNome(data[1]);
                comune.setProvincia(provincia);
                comuneRepo.save(comune);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
