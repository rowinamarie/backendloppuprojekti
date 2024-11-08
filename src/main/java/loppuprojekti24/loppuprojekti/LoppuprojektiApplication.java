package loppuprojekti24.loppuprojekti;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LoppuprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner tapahtumaDemo() {
		return (args) -> {
			
		};
	}
}
