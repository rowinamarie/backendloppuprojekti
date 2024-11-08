package loppuprojekti24.loppuprojekti;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;


@SpringBootApplication
public class LoppuprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner tapahtumaDemo(KaupunkiRepository kaupunkiRepository, RetkiRepository retkiRepository) {
		return (args) -> {

			log.info("Lisätään testikaupungit");

			Kaupunki kaupunki1 = new Kaupunki ("Saimaa");
			Kaupunki kaupunki2 = new Kaupunki ("Inari");
			Kaupunki kaupunki3 = new Kaupunki ("Turku");

			kaupunkiRepository.save(kaupunki1);
			kaupunkiRepository.save(kaupunki2);
			kaupunkiRepository.save(kaupunki3);


			log.info("Lisätään testitapahtumia");
			retkiRepository.save(new Retki( "Kesäretki Saimaalle", "Kolmen päivän retki kauniilla Saimaan vesistöalueella. Ohjelmassa melontaa, kalastusta ja yöpymistä teltoissa.", kaupunki1 ));
			retkiRepository.save(new Retki("Vaellus Lapin tuntureilla", "Viiden päivän vaellus läpi upeiden Lapin tunturimaisemien. Matkalla yövytään laavuilla ja ihastellaan revontulia." , kaupunki2));	
			retkiRepository.save(new Retki("Melonta ja saaristoretki", "Kolmen päivän melontaretki saaristossa, jossa tutustutaan useisiin saariin ja maistellaan paikallisia herkkuja.", kaupunki3));
			
		};
	}
}
