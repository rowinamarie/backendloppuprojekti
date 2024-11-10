package loppuprojekti24.loppuprojekti;

import java.time.LocalDate;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;
import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;


@SpringBootApplication
public class LoppuprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner tapahtumaDemo(KaupunkiRepository kaupunkiRepository, RetkiRepository retkiRepository, OsallistujaRepository osallistujaRepository) {
		return (args) -> {

		Kaupunki kaupunki1 = new Kaupunki("Saimaa");
		Kaupunki kaupunki2 = new Kaupunki("Tampere");
		Kaupunki kaupunki3 = new Kaupunki("Turku");
        kaupunkiRepository.save(kaupunki1);
		kaupunkiRepository.save(kaupunki2);
		kaupunkiRepository.save(kaupunki3);

        // Luodaan testiretki
        Retki retki1 = new Retki("Kesäretki Saimaalle", "Kolmen päivän retki.", kaupunki1, new HashSet<>());
        retkiRepository.save(retki1);

        // Luodaan osallistujat
        Osallistuja osallistuja1 = new Osallistuja("Matti", retki1);
        Osallistuja osallistuja2 = new Osallistuja("Liisa", retki1);

        osallistujaRepository.save(osallistuja1);
        osallistujaRepository.save(osallistuja2);
		};
	}
}
