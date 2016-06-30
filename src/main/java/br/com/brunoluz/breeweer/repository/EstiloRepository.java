package br.com.brunoluz.breeweer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brunoluz.breeweer.model.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long> {

}
