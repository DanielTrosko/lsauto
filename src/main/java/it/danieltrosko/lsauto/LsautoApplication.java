package it.danieltrosko.lsauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LsautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsautoApplication.class, args);
	}

}
