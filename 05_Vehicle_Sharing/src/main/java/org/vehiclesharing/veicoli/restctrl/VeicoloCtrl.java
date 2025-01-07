package org.vehiclesharing.veicoli.restctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vehiclesharing.veicoli.dtos.UtenteDto;
import org.vehiclesharing.veicoli.entities.Utente;
import org.vehiclesharing.veicoli.entities.Veicolo;
import org.vehiclesharing.veicoli.services.VeicoloService;

@RestController
@RequestMapping("/api/veicolo")
@CrossOrigin(origins = "http://localhost:5500", 
			 allowCredentials = "true", 
			 methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, 
			 allowedHeaders = "*", 
			 exposedHeaders = "*")
public class VeicoloCtrl {
	
	@Autowired
	VeicoloService veicoloService;
	
	//-------------------------------GET ALL-----------------------
	@GetMapping
	public ResponseEntity<List<Veicolo>> getAll(){
		try {
			List<Veicolo> veicoli = veicoloService.getAllVeicoli();
			return ResponseEntity.ok(veicoli); 
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ArrayList<Veicolo>());
		}
	}
	//-------------------------------GET BY ID----------------------------
	@GetMapping("/{id}")
	public ResponseEntity<Veicolo> getById(@PathVariable long id){
		try {
			Veicolo veicolo = veicoloService.getVeicoloById(id);
			if(veicolo != null) {
				return ResponseEntity.ok(veicolo);				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Veicolo());
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
	}
	
	//--------------------------------------POST--------------------------------------
	@PostMapping
	public ResponseEntity<?> postVeicolo(@RequestBody Veicolo veicolo){
		try {
			Veicolo veicoloAggiunto = veicoloService.aggiungiVeicolo(veicolo);
			
			return ResponseEntity.ok(veicoloAggiunto);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Errore nell'inserimento di dati. Controllare le proprietà dell'oggetto");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
		
	}
	
	//-----------------------------------DELETE-------------------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVeicoloById(@PathVariable long id){
		try {
			Veicolo trovato = veicoloService.getVeicoloById(id);
			
			if(trovato != null) {
				veicoloService.cancellaVeicoloById(id);
				return ResponseEntity.ok("Cancellato veicolo con id:" + id);
			}else {
				return ResponseEntity.badRequest().body("Il veicolo non esiste");
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
	}
	
	
	
	
	
}
