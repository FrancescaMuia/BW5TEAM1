package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Comuni;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ComuniRepository;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ComuniService {

    @Autowired
    private ComuniRepository comuneRepo;

    @Autowired
    private ProvinceRepository provinciaRepo;

    @PostConstruct
    public void init() {
        String csvfile="F:\\Documents\\Corso Epicode\\Backend\\m5\\s4\\BW5TEAM1\\BW5TEAM1\\ees\\src\\main\\resources\\comuni-italiani.csv";
        String line;

        try (BufferedReader br=new BufferedReader(new FileReader(csvfile))) {
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split(";");
                Comuni comune = new Comuni();
                comune.setNome(data[2]);
                Province provincia = provinciaRepo.findByNome(data[3]);
                System.out.println(provincia.getNome());
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
