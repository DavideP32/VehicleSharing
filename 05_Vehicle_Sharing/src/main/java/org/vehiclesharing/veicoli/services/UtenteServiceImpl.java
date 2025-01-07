package org.vehiclesharing.veicoli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehiclesharing.veicoli.dtos.UtenteDto;
import org.vehiclesharing.veicoli.entities.Utente;
import org.vehiclesharing.veicoli.repositories.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	private UtenteRepository utenteRepository;

//	@Override
//	public List<Utente> getAllUtenti() {
//		List<Utente> utenti = utenteRepository.findAll();
//		
//		return utenti;
//	}

	
	//-----------------------------------GET ALL-------------------------------
	@Override
	public List<UtenteDto> getAllUtentiDto() {
		List<Utente> utenti = utenteRepository.findAll();
		
		return this.convertToDto(utenti);
		
	}
	
	//----------------------------------GET DTO BY ID------------------------------
	@Override
	public UtenteDto getUtenteDtoById(long id) {
		Optional<Utente> optional = utenteRepository.findById(id);
		
		if(optional.isPresent()) {
			UtenteDto utente = convertToDto(optional.get());
			return utente;
		}else {
			return null;
		}
	}
	
	//--------------------------------GET BY ID-----------------------------
	public Utente prendiPerId(long id) {
		Optional<Utente> optional = utenteRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//--------------------------------GET BY EMAIL---------------------------
	public UtenteDto prendiUtenteByEmail(String email) {
		return this.convertToDto(utenteRepository.findByEmail(email));
	}
	
	//--------------------------------AGGIUNGI UTENTE-------------------------
	@Override
	public UtenteDto aggiungiUtente(Utente utente) {
		utente.setId(0L); //azzero l'id in modo che si aggiorni automaticamente!
		utenteRepository.save(utente);
		return this.convertToDto(utente);
	}
	
	//-------------------------------AGGIORNA UTENTE--------------------------
	
	@Override
	public UtenteDto aggiornaUtente(Utente utente, Utente trovato) {
		trovato.setNome(utente.getNome());
		trovato.setCognome(utente.getCognome());
		trovato.setDataNascita(utente.getDataNascita());
		trovato.setEmail(utente.getEmail());
		trovato.setRuolo(utente.getRuolo());
		
		utenteRepository.save(trovato);
		return this.convertToDto(utente);
	}
	
	
	//-------------------------------CANCELLA UTENTE-------------------------------
	
	public void cancellaUtenteById(long id) {
		utenteRepository.deleteById(id);
	}
	
	
	//_-------------------------------------<LOGIN---------------------------------
	
	private boolean verificaPsw(String passwordInserita, String passwordSalvata) {
		return passwordInserita.equals(passwordSalvata);
	}
	
	
	public Utente verificaCredenziali(String email, String password) {
		
		Utente u = utenteRepository.findByEmail(email);
		
		if(u != null && verificaPsw(password, u.getPassword())) {
			return u;
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------CONVERTO GLI UTENTI ENTITY A UTENTEDTO----------------------------------
	//Facciamo questo perché così possiamo mostrare solo il dto invece dell'intero utente entity. 
	private List<UtenteDto> convertToDto(List<Utente> utenti){
		List<UtenteDto> utentiDto = new ArrayList();
		for (Utente utente : utenti) {
			utentiDto.add(convertToDto(utente));
		}
		
		return utentiDto;
	}
	
	
	private UtenteDto convertToDto(Utente utente) {
		
		UtenteDto utenteDto = new UtenteDto(
				utente.getId(),
				utente.getNome(),
				utente.getCognome(),
				utente.getDataNascita(),
				utente.getEmail(),
				utente.getRuolo()
		);
		
		return utenteDto;
		
	}

	
	
	

}
