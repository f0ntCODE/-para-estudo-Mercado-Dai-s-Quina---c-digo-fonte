package edu.squina.daisquina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DaisquinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaisquinaApplication.class, args);
	}

}
