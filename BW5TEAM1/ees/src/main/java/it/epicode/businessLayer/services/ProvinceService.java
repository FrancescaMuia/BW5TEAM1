package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProvinceService {

    @Autowired
    private ProvinceRepository provinciaRepo;

    @PostConstruct
    public void init(){
        String csvfile="src/main/resources/province-italiane.csv";
        String line;

        try (BufferedReader br=new BufferedReader(new FileReader(csvfile))) {
            while ((line=br.readLine()) != null){
                String[] data = line.split(";");
                Province provincia = new Province();
                provincia.setNome(data[1]);
                provincia.setRegione(data[2]);
                provinciaRepo.save(provincia);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
