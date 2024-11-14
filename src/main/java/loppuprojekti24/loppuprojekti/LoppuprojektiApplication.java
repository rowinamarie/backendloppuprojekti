package loppuprojekti24.loppuprojekti;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
;

@SpringBootApplication
public class LoppuprojektiApplication {

	//private static final Logger log = LoggerFactory.getLogger(LoppuprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoppuprojektiApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner tapahtumaDemo(KaupunkiRepository kaupunkiRepository, RetkiRepository retkiRepository,
			OsallistujaRepository osallistujaRepository, KayttajaRepository kayttajaRepository) {
		return (args) -> {

			log.info("Lisätään testikaupungit");
			Kaupunki kaupunki1 = new Kaupunki("Saimaa");
			Kaupunki kaupunki2 = new Kaupunki("Inari");
			Kaupunki kaupunki3 = new Kaupunki("Turku");
			kaupunkiRepository.save(kaupunki1);
			kaupunkiRepository.save(kaupunki2);
			kaupunkiRepository.save(kaupunki3);

			// Luodaan testiretki
			log.info("Lisätään testiretket");
			Retki retki1 = new Retki("Kesäretki Saimaalle", "Kolmen päivän retki.", kaupunki1,
					LocalDate.of(2024, 6, 15), new HashSet<>());
			Retki retki2 = new Retki("Ruskavaellus Lapissa", "Nukkumista tähtitaivaan alla.", kaupunki2,
					LocalDate.of(2024, 9, 8), new HashSet<>());
			retkiRepository.save(retki1);
			retkiRepository.save(retki2);

			// Luodaan osallistujat
			log.info("Lisätään testiosallistujat");
			Osallistuja osallistuja1 = new Osallistuja("Matti", "Meikaläinen", "matti.meikalainen@sahkoposti.fi",
					retki1);
			Osallistuja osallistuja2 = new Osallistuja("Liisa", "Korhonen", "liisa@sahkposti.fi", retki2);

			retki1.getOsallistujat().add(osallistuja1);
			retki1.getOsallistujat().add(osallistuja2);

			osallistujaRepository.save(osallistuja1);
			osallistujaRepository.save(osallistuja2);

			Kayttaja kayttaja1 = new Kayttaja("Oppilas",
					"$2a$12$xb2011I0iidDDSNtDbmQGOPGkSKfePo2gCmB7T.77r.HrYAlw4W.C", "OPPILAS");
			Kayttaja kayttaja2 = new Kayttaja("Opettaja",
					"$2a$12$gNMXsAo29KleVf86UVrB1.4lPBiPN454rd3X0gYBMVy9AePtEhAXK", "OPETTAJA");
			kayttajaRepository.save(kayttaja1);
			kayttajaRepository.save(kayttaja2);

		};
	}*/
}
