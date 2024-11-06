package loppuprojekti24.loppuprojekti.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OsallistujaRepository extends JpaRepository <Osallistuja, Long>{

    List<Osallistuja> findByOsallistujanimi (String osallistujanimi);

}
