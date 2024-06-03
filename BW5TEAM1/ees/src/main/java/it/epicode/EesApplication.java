package it.epicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "it.epicode.dataLayer.entities")
@SpringBootApplication
public class EesApplication {
	public static void main(String[] args) {
		SpringApplication.run(EesApplication.class, args);
	}
}
