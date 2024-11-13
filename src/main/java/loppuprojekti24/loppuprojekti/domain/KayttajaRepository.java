package loppuprojekti24.loppuprojekti.domain;

import org.springframework.data.repository.CrudRepository;


public interface KayttajaRepository extends CrudRepository <Kayttaja, Long> {

Kayttaja findByKayttajatunnus (String kayttajatunnus); 

}
