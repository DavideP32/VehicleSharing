package org.vehiclesharing.veicoli.services;

import java.util.List;

import org.vehiclesharing.veicoli.dtos.UtenteDto;
import org.vehiclesharing.veicoli.entities.Utente;

public interface UtenteService {

//	List<Utente> getAllUtenti();
	List<UtenteDto> getAllUtentiDto();
	
	UtenteDto getUtenteDtoById(long id);
	Utente prendiPerId(long id);
	UtenteDto prendiUtenteByEmail(String email);
	
	UtenteDto aggiungiUtente(Utente utente);
	UtenteDto aggiornaUtente(Utente utente, Utente trovato);
	void cancellaUtenteById(long id);
	
	
	public Utente verificaCredenziali(String email, String password);
	
	
	
}
