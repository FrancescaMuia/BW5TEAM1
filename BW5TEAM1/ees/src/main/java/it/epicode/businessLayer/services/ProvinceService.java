package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinciaRepo;

    @PostConstruct
    public void init(){
        String csvfile="F:\\Documents\\Corso Epicode\\Backend\\m5\\s4\\BW5TEAM1\\BW5TEAM1\\ees\\src\\main\\resources\\province-italiane.csv";
        String line;

        try (BufferedReader br=new BufferedReader(new FileReader(csvfile))) {
            br.readLine();
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

