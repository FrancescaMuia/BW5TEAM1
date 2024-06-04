package it.epicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class EesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EesApplication.class, args);
	}

}
