package it.prova.gestionedottore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionedottore.model.Dottore;
import it.prova.gestionedottore.service.DottoreService;

@SpringBootApplication
public class GestionedottoreApplication implements CommandLineRunner {
	
	@Autowired
	private DottoreService service;

	public static void main(String[] args) {
		SpringApplication.run(GestionedottoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Popolo DB
		service.inserisciNuovo(new Dottore("Mario","Rossi","COD-Mrossi", true, false));
		service.inserisciNuovo(new Dottore("Peppe","Bianchi","COD-Pbianchi", true, false));
		service.inserisciNuovo(new Dottore("Antonio","Marrone","COD-Amarrone", false, false));
}

}
