package org.vehiclesharing.veicoli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vehiclesharing.veicoli.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//qui metto le query DB
	Utente findByEmail(String email);
	
}
