package br.com.brunoluz.breeweer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brunoluz.breeweer.model.Cerveja;

@Repository
public interface CervejasRepository extends JpaRepository<Cerveja, Long> {

}
