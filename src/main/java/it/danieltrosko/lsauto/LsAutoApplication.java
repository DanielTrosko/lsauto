package it.danieltrosko.lsauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class LsAutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsAutoApplication.class, args);


	}

}
