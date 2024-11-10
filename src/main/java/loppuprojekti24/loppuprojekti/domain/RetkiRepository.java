package loppuprojekti24.loppuprojekti.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RetkiRepository extends CrudRepository <Retki, Long> {

    List <Retki> findByRetkinimi (String retkinimi);

    Optional<Retki> findById(Long id);

}
