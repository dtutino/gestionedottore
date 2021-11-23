package it.prova.gestionedottore.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestionedottore.model.Dottore;

public interface DottoreRepository extends CrudRepository<Dottore, Long> {
	
	public Dottore findByCodiceDipendente(String codiceDipendente);

}
