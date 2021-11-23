package it.prova.gestionedottore.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.gestionedottore.model.Dottore;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottoreDTO {
	
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDipendente;
	private Boolean inServizio;
	private Boolean inVisita;
	
	public DottoreDTO() {
		super();
	}

	public DottoreDTO(Long id, String nome, String cognome, String codiceDipendente, Boolean inServizio,
			Boolean inVisita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public DottoreDTO(Long id, String nome, String cognome, String codiceDipendente) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public DottoreDTO(String nome, String cognome, String codiceDipendente, Boolean inServizio, Boolean inVisita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public DottoreDTO(String nome, String cognome, String codiceDipendente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceDottore() {
		return codiceDipendente;
	}

	public void setCodiceDottore(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}

	public Boolean getInServizio() {
		return inServizio;
	}

	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}

	public Boolean getInVisita() {
		return inVisita;
	}

	public void setInVisita(Boolean inVisita) {
		this.inVisita = inVisita;
	}
	
	public Dottore buildDottoreModel() {
		return new Dottore(this.id, this.nome, this.cognome, this.codiceDipendente, this.inServizio, this.inVisita);
	}

	public static DottoreDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		return new DottoreDTO(dottoreModel.getId(), dottoreModel.getNome(), dottoreModel.getCognome(),
				dottoreModel.getCodiceDipendente());
	}

	public static List<DottoreDTO> createDottoreDTOListFromModelList(List<Dottore> modelListInput) {
		return modelListInput.stream()
				.map(dottoreModel -> new DottoreDTO(dottoreModel.getId(), dottoreModel.getNome(),
						dottoreModel.getCognome(), dottoreModel.getCodiceDipendente(), dottoreModel.getInServizio(), dottoreModel.getInVisita()))
				.collect(Collectors.toList());
	}

}
