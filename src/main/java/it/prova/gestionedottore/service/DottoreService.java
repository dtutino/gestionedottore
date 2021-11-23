package it.prova.gestionedottore.service;

import java.util.List;

import it.prova.gestionedottore.model.Dottore;

public interface DottoreService {
	
	public Dottore inserisciNuovo(Dottore transientInstance);

	public List<Dottore> listAll();

	public Dottore cariscaSingoloElemento(Long id);
	
	public Dottore cercaPerCodiceDipendente(String codiceDipendenteInput);

}
