package loppuprojekti24.loppuprojekti;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Kayttaja;
import loppuprojekti24.loppuprojekti.domain.KayttajaRepository;
import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

@SpringBootApplication
public class LoppuprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository tapahtumaRepository, KaupunkiRepository kaupunkiRepository, KayttajaRepository kayttajaRepository) {
		return (args) -> {

			log.info("Lisätään testikaupungit");

			Kaupunki kaupunki1 = new Kaupunki ("Helsinki");
			Kaupunki kaupunki2 = new Kaupunki ("Tampere");
			Kaupunki kaupunki3 = new Kaupunki ("Turku");

			kaupunkiRepository.save(kaupunki1);
			kaupunkiRepository.save(kaupunki2);
			kaupunkiRepository.save(kaupunki3);


			log.info("Lisätään testitapahtumia");
			tapahtumaRepository.save(new Tapahtuma( "Konsertti", "uusitapahtuma",LocalDate.of(2024, 5, 20), kaupunki1 ));
			tapahtumaRepository.save(new Tapahtuma("Juhlat", "koko perheen tapahtuma", LocalDate.of(2024, 6, 15), kaupunki2));	
			
			tapahtumaRepository.save(new Tapahtuma("Illallinen", "3 ruokalajin illallinen", LocalDate.of(2024, 7, 10), kaupunki3));
			
			log.info("Hakee kaikki tapahtumat");
			for (Tapahtuma tapahtuma : tapahtumaRepository.findAll()) {
				log.info(tapahtuma.toString());
			}
			log.info("Haetaan konsertteja");
			for (Tapahtuma tapahtuma : tapahtumaRepository.findByNimi("Konsertti")) {
				log.info(tapahtuma.toString());
			}

			Kayttaja kayttaja1 = new Kayttaja ("user", "$2a$12$AoWTTdAyXOtcxJGosMvY.uik1WECxRhCcxX7J9D/oZGDiizu9Kb9W", "USER");
			Kayttaja kayttaja2 = new Kayttaja ("admin", "$2a$12$6c0D6Qm5VHw6Ikjqx04g9eP9FG.lzbpUHKwSN.yc9NdGKkPypTiJm", "ADMIN");
			kayttajaRepository.save(kayttaja1);
			kayttajaRepository.save(kayttaja2);
		};

		
	}
	@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }



}
