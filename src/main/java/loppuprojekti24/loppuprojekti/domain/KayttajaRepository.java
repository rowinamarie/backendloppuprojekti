package loppuprojekti24.loppuprojekti.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface KayttajaRepository extends CrudRepository <Kayttaja, Long> {

    Kayttaja findByKayttajanimi(String kayttajanimi);

}
