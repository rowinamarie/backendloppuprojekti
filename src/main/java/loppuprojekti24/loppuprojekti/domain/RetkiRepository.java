package loppuprojekti24.loppuprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RetkiRepository extends CrudRepository <Retki, Long> {

    List <Retki> findByRetkinimi (String retkinimi);

}
