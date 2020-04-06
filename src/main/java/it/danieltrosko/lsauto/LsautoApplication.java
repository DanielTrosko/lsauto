package it.danieltrosko.lsauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LsautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsautoApplication.class, args);


		BCryptPasswordEncoder jakis = new BCryptPasswordEncoder();
		String p = "dupa";
		String ta = jakis.encode(p);
		System.err.println(ta);





	}

}
