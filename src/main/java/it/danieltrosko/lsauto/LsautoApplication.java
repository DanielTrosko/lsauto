package it.danieltrosko.lsauto;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.model.entites.User;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class LsautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsautoApplication.class, args);





	}

}
