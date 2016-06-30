package br.com.brunoluz.breeweer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brunoluz.breeweer.model.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

	
}
