package org.vehiclesharing.veicoli.restctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vehiclesharing.veicoli.dtos.UtenteDto;
import org.vehiclesharing.veicoli.entities.Utente;
import org.vehiclesharing.veicoli.login.LoginRequest;
import org.vehiclesharing.veicoli.login.SessioneUtente;
import org.vehiclesharing.veicoli.services.UtenteService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/utente")
//@CrossOrigin(origins = "http://localhost:5500",
//			allowCredentials = "true",
//			methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
//			allowedHeaders = "*",
//			exposedHeaders = "*"
//			)
public class UtenteCtrl {

	@Autowired
	UtenteService utenteService;
	
	//---------------GET ALL UTENTI------------------------
	@GetMapping
	public ResponseEntity<List<UtenteDto>> getAll(){
		
		try {
			List<UtenteDto> utentiDto = utenteService.getAllUtentiDto();
			return ResponseEntity.ok(utentiDto);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ArrayList<UtenteDto>());
		}
		
	}
	
	
	//------------------------------------------GET UTENTE PER ID----------------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<UtenteDto> getById(@PathVariable long id){
		try {
			UtenteDto utenteDto = utenteService.getUtenteDtoById(id);
			if(utenteDto != null) {
				return ResponseEntity.ok(utenteDto);				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UtenteDto());
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new UtenteDto());
		}
	}
	
	
	//------------------------------------POST UTENTE-------------------------
	@PostMapping
	public ResponseEntity<?> postUtente(@RequestBody Utente utente){
		try {
			UtenteDto utenteDto = utenteService.aggiungiUtente(utente);
			
			return ResponseEntity.ok(utenteDto);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Errore nell'inserimento di dati. Controllare le proprietà dell'oggetto");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Utente());
		}
		
	}
	
	//--------------------------------------UPDATE UTENTE----------------------------
	
	@PutMapping
	public ResponseEntity<?> putUtente(@RequestBody Utente utente){
		try {
			Utente trovato = utenteService.prendiPerId(utente.getId());
			UtenteDto trovatoEmail = utenteService.prendiUtenteByEmail(utente.getEmail());
			
			if(trovato != null && trovatoEmail.getId() == trovato.getId()) {
				UtenteDto utenteDto = utenteService.aggiornaUtente(utente, trovato);
				return ResponseEntity.ok(utenteDto);
			}else if (trovatoEmail.getId() != trovato.getId()){
				return ResponseEntity.badRequest().body("Email non corretta!");
			}else {
				return ResponseEntity.badRequest().body("Errore, utente non trovato");
			}
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new UtenteDto());
		}
	}
	
	
	//---------------------------------------DELETE UTENTE BY ID--------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUtenteById(@PathVariable long id){
		try {
			UtenteDto trovato = utenteService.getUtenteDtoById(id);
			
			if(trovato != null) {
				utenteService.cancellaUtenteById(id);
				return ResponseEntity.ok("Cancellato l'utente con id:" + id);
			}else {
				return ResponseEntity.badRequest().body("L'utente non esiste");
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new UtenteDto());
		}
	}
	
	
	
	//-------------------------------LOGIN UTENTE--------------------------------------
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session){
		try {
			Utente utente = utenteService.verificaCredenziali(loginRequest.getEmail(), loginRequest.getPassword());
			
			if(utente != null) {
				SessioneUtente sessione = new SessioneUtente(utente.getId(), utente.getNome(), utente.getEmail(), utente.getRuolo());

				session.setAttribute("utente", sessione);
				
				return ResponseEntity.ok(sessione);
			}else {
				return ResponseEntity.status(401).body("Credenziali non valide");
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Errore durante il login: " + e.getMessage());
		}
	}
	
	
	//---------------------------------------LOGOUT UTENTE-----------------------------------------
	@PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.removeAttribute("utente");
        session.invalidate();
        return ResponseEntity.ok("Logout effettuato con successo");
    }
	
	
	//--------------------------------GET UTENTE LOGGATO-----------------------------------
	
	@GetMapping("/isLogged")
    public ResponseEntity<?> getUtenteLoggato(HttpSession session) {
        SessioneUtente sessioneUtente = (SessioneUtente) session.getAttribute("utente");
        if (sessioneUtente != null) {
            return ResponseEntity.ok(sessioneUtente);
        }
        return ResponseEntity.status(401).body("Utente non autenticato");
    }
	
	
}
