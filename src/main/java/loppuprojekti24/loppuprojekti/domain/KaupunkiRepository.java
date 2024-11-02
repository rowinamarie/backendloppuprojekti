package loppuprojekti24.loppuprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KaupunkiRepository extends CrudRepository<Kaupunki, Long> {
    List<Kaupunki> findByKaupunkinimi(String kaupunkinimi);
}
