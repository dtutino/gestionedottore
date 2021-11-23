package it.prova.gestionedottore.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestionedottore.dto.DottoreDTO;
import it.prova.gestionedottore.model.Dottore;
import it.prova.gestionedottore.service.DottoreService;

@RestController
@RequestMapping("/api/dottore")
public class DottoreController {
	
	@Autowired
	private DottoreService service;
	
	@GetMapping("/{codiceDipendente}")
	public Dottore findById(@PathVariable(value = "codiceDipendente", required = true) String codiceDipendenteInput) {
		return service.cercaPerCodiceDipendente(codiceDipendenteInput);
	}

	@GetMapping
	public List<Dottore> getAll() {
		return (List<Dottore>) service.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@RequestBody DottoreDTO input) {
		// ANDREBBE GESTITA CON ADVICE!!!
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (input.getId() != null)
			throw new RuntimeException("Non è ammesso fornire un id per la creazione");
			
		Dottore newEntry = input.buildDottoreModel();
		
		DottoreDTO result = DottoreDTO
				.buildDottoreDTOFromModel(service.inserisciNuovo(newEntry));
		return result;
	}

}
