package loppuprojekti24.loppuprojekti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

@SpringBootApplication
public class LoppuprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository tapahtumaRepository) {
		return (args) -> {
			log.info("Lisätään testitapahtumia");
			tapahtumaRepository.save(new Tapahtuma( "Konsertti", "Helsinki", "uusitapahtuma"));
			tapahtumaRepository.save(new Tapahtuma("Juhlat", "Tampere", "koko perheen tapahtum"));	
			
			tapahtumaRepository.save(new Tapahtuma("Illallinen", "Espoo", "3 ruokalajin illallinen"));
			
			log.info("Hakee kaikki tapahtumat");
			for (Tapahtuma tapahtuma : tapahtumaRepository.findAll()) {
				log.info(tapahtuma.toString());
			}
			log.info("haetaan kaikki konsertit");
			for (Tapahtuma tapahtuma : tapahtumaRepository.findByNimi("Konsertti")) {
				log.info(tapahtuma.toString());
			}

		};
	}

}
